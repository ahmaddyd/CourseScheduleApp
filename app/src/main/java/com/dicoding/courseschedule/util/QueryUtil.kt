package com.dicoding.courseschedule.util

import androidx.sqlite.db.SimpleSQLiteQuery

object QueryUtil {

    fun sortedQuery(sortType: SortType): SimpleSQLiteQuery {
        val query = StringBuilder().append("SELECT * FROM course ")
        when (sortType) {
            SortType.TIME -> query.append("ORDER BY day, strftime('%H:%M', startTime)")
            SortType.COURSE_NAME -> query.append("ORDER BY courseName COLLATE NOCASE")
            SortType.LECTURER -> query.append("ORDER BY lecturer COLLATE NOCASE")
        }

        return SimpleSQLiteQuery(query.toString())
    }

    fun nearestQuery(type: QueryType): SimpleSQLiteQuery {
        var query = ""
        when (type) {
            QueryType.CURRENT_DAY -> query = """
                 SELECT * FROM course 
                 WHERE day = (strftime('%w', 'now') + 1)
                 AND strftime('%H:%M', startTime) > strftime('%H:%M', 'now')
                 ORDER BY strftime('%H:%M', startTime) ASC LIMIT 1
                 """

            QueryType.NEXT_DAY -> query = """
                 SELECT * FROM course 
                 WHERE day > (strftime('%w', 'now') + 1)
                 ORDER BY day,strftime('%H:%M', startTime) ASC LIMIT 1
                 """

            QueryType.PAST_DAY -> query = """
                 SELECT * FROM course 
                 WHERE day >= 0
                 ORDER BY day, strftime('%H:%M', startTime) ASC LIMIT 1
                 """
        }

        return SimpleSQLiteQuery(query)
    }
}

enum class QueryType {
    CURRENT_DAY,
    NEXT_DAY,
    PAST_DAY
}