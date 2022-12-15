package todayquest.quest.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
@Getter
public enum QuestDifficulty {

    VERY_EASY(1, 10, "매우 쉬움"),
    EASY(2, 20, "쉬움"),
    NORMAL(3, 30, "보통"),
    HARD(4, 40, "어려움"),
    VERY_HARD(5, 50, "매우 어려움");

    int experience;
    int gold;
    String text;

    QuestDifficulty(int experience, int gold, String text) {
        this.experience = experience;
        this.gold = gold;
        this.text = text;
    }

    public static List<QuestDifficulty> getEnumList() {
        return Arrays.stream(QuestDifficulty.values())
                .collect(Collectors.toList());
    }
}