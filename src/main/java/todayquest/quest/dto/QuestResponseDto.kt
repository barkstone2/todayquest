package todayquest.quest.dto

import todayquest.quest.entity.DetailQuestState
import todayquest.quest.entity.Quest
import todayquest.quest.entity.QuestState
import todayquest.quest.entity.QuestType
import todayquest.reward.dto.RewardResponseDto
import java.time.LocalDateTime

data class QuestResponseDto(
    var questId: Long? = null,
    var title: String? = null,
    var description: String? = null,
    var seq: Long? = null,
    var state: QuestState? = null,
    var rewards: List<RewardResponseDto>? = null,
    var lastModifiedDate: LocalDateTime? = null,
    var detailQuests: List<DetailQuestResponseDto>? = null,
    var canComplete : Boolean? = null,
    var type: QuestType? = null,
) {

    companion object {
        @JvmStatic
        fun createDto(quest: Quest): QuestResponseDto {
            return QuestResponseDto(
                questId = quest.id,
                title = quest.title,
                description = quest.description,
                seq = quest.seq,
                state = quest.state,
                lastModifiedDate = quest.lastModifiedDate,
                rewards = quest.rewards.map {
                    RewardResponseDto.createDto(
                        it.reward
                    )
                }.toCollection(mutableListOf()),
                detailQuests = quest.detailQuests.map {
                    DetailQuestResponseDto.createDto(
                        it
                    )
                }.toCollection(mutableListOf()),
                canComplete = quest.detailQuests.all { dq -> dq.state == DetailQuestState.COMPLETE },
                type = quest.type,
            )
        }
    }

}