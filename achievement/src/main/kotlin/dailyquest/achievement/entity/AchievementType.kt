package dailyquest.achievement.entity

enum class AchievementType(val representationFormat: String) {
    QUEST_REGISTRATION("퀘스트 %d개 등록"),
    QUEST_COMPLETION("퀘스트 %d개 완료"),
    QUEST_CONTINUOUS_REGISTRATION("퀘스트 %d일 연속 등록"),
    QUEST_CONTINUOUS_COMPLETION("퀘스트 %d일 연속 완료"),
    GOLD_EARN("총 골드 %,d 획득"),
    PERFECT_DAY("완벽한 하루 %d회 달성");

    override fun toString(): String {
        return this.name
    }
}