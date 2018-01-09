package io.github.bu3.embeddedmysql

import io.github.bu3.embeddedmysql.persistence.DataRepository
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest
class EmbeddedMysqlApplicationTests {

	@Autowired
	lateinit var dataRepository: DataRepository

	@Test
	fun shouldLoadData() {
        val results = dataRepository.search("$.name", "John Doe")
        assertEquals(results.size, 1)
        assertEquals(results[0].data, "{\"employeeId\":1,\"name\":\"John Doe\", \"location\":\"Dublin\"}")
	}

}
