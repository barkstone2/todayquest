package todayquest.quest.dto

import com.fasterxml.jackson.annotation.JsonFormat
import todayquest.quest.entity.DetailQuestState
import todayquest.quest.entity.Quest
import todayquest.quest.entity.QuestState
import todayquest.quest.entity.QuestType
import java.time.LocalDateTime

data class QuestResponse(
    var questId: Long? = null,
    var title: String? = null,
    var description: String? = null,
    var seq: Long? = null,
    var state: QuestState? = null,

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    var lastModifiedDate: LocalDateTime? = null,
    var detailQuests: List<DetailResponse>? = null,
    var canComplete : Boolean = false,
    var type: QuestType? = null,
) {

    companion object {
        @JvmStatic
        fun createDto(quest: Quest): QuestResponse {
            return QuestResponse(
                questId = quest.id,
                title = quest.title,
                description = quest.description,
                seq = quest.seq,
                state = quest.state,
                lastModifiedDate = quest.lastModifiedDate,
                detailQuests = quest.detailQuests.map {
                    DetailResponse.createDto(it)
                }.toCollection(mutableListOf()),
                canComplete = quest.detailQuests.all { dq -> dq.state == DetailQuestState.COMPLETE },
                type = quest.type,
            )
        }
    }

}