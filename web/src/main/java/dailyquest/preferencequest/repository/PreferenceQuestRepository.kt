package dailyquest.preferencequest.repository

import dailyquest.preferencequest.entity.PreferenceQuest
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface PreferenceQuestRepository : JpaRepository<PreferenceQuest, Long> {
    @Query("select pq from PreferenceQuest pq left join fetch pq._preferenceDetailQuests where pq.id = :preferenceQuestId and pq.userId = :userId")
    fun findByIdAndUserIdAndDeletedDateIsNull(@Param("preferenceQuestId") preferenceQuestId: Long, @Param("userId") userId: Long): PreferenceQuest?

    @Query("select pq from PreferenceQuest pq left join fetch pq._preferenceDetailQuests where pq.userId = :userId and pq.deletedDate is null")
    fun getActivePrefQuests(@Param("userId") userId: Long): List<PreferenceQuest>

    @Query("select count(q) from PreferenceQuest pq left join Quest q on q.userId = pq.userId and q.preferenceQuest.id = pq.id where pq.userId = :userId and pq.deletedDate is null group by pq.id")
    fun getUsedCountOfActivePrefQuests(@Param("userId") userId: Long): List<Long>
}