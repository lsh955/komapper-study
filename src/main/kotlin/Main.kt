import dto.Employee
import dto.employee
import org.komapper.core.dsl.Meta
import org.komapper.core.dsl.QueryDsl
import org.komapper.jdbc.JdbcDatabase

fun main() {
    val database = JdbcDatabase("jdbc:h2:mem:quickstart;DB_CLOSE_DELAY=-1")

    database.withTransaction {
        val e = Meta.employee

        database.runQuery {
            QueryDsl.create(e)
        }

        database.runQuery {
            QueryDsl.insert(e).multiple(Employee(name = "lsh"), Employee(name = "kim"))
        }

        val employees = database.runQuery{
            QueryDsl.from(e).orderBy(e.id)
        }

        for ((i, employee) in employees.withIndex()) {
            println("RESULT $i: $employee")
        }
    }
}