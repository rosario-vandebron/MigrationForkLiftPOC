package database

import java.sql.Timestamp
import java.util.UUID

package object accountDomain {

  trait BaseEntity {
    val id: UUID
    val createdAt: Option[Timestamp]
    val lastModified: Option[Timestamp]
  }

  case class SmartChargeLocation(
                                  id: UUID,
                                  accountId: UUID,
                                  connectionId: String,
                                  postalCode: String,
                                  longitude: Double,
                                  latitude: Double,
                                  chargerCapacity: Double,
                                  createdAt: Option[Timestamp] = None, lastModified: Option[Timestamp] = None
                                ) extends BaseEntity

  case class Account(id: UUID, customerReference: Option[String], test:Int, test2:String, createdAt: Option[Timestamp] = None, lastModified: Option[Timestamp] = None) extends BaseEntity

}