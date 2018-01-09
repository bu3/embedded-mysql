package io.github.bu3.embeddedmysql.persistence

import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Lob

@Entity(name = "EMPLOYEES")
data class Employee(
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    val id:Long,

    @Lob
    @Column
    val data: String

){
    constructor() : this(0, "")
}

interface DataRepository : CrudRepository<Employee, Long> {

    @Query("select id, data from EMPLOYEES e where JSON_SEARCH(e.data, 'all', ?2, NULL, ?1) is not null", nativeQuery = true)
    fun search(path:String, value: String): List<Employee>

}