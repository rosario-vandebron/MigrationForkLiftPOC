package database

import java.sql.Timestamp
import java.util.UUID

import database.accountDomain.{Account, SmartChargeLocation}
import slick.lifted.{ProvenShape, TableQuery, Tag}
import slick.jdbc.PostgresProfile.api._

object Tables {
  private val accountsTableReference = "account_id"

  abstract class BaseTable[T](tag: Tag, name: String) extends Table[T](tag, name) {
    def id = column[UUID]("id", O.PrimaryKey)

    def createdAt = column[Option[Timestamp]]("created_at")

    def lastModified = column[Option[Timestamp]]("last_modified")
  }

  class Accounts(tag: Tag) extends BaseTable[Account](tag, "accounts") {

    def customerReference = column[Option[String]]("customer_reference", O.Unique)

    def test = column[Int]("test")

    def test2 = column[String]("test2")

    def * : ProvenShape[Account] = (id, customerReference, test, test2, createdAt, lastModified) <> (Account.tupled, Account.unapply)
  }

  val accountsTableQ: TableQuery[Accounts] = TableQuery[Accounts]

  class SmartChargeLocations(tag: Tag) extends BaseTable[SmartChargeLocation](tag, "smart_charge_locations") {

    def accountId = column[UUID](accountsTableReference)

    def account = foreignKey("LOCATION_ACCOUNT_FK", accountId, accountsTableQ)(_.id, onDelete = ForeignKeyAction.Cascade)

    def connectionId = column[String]("connection_id")

    def postalCode = column[String]("postal_code")

    def longitude = column[Double]("longitude")

    def latitude = column[Double]("latitude")

    def chargerCapacity = column[Double]("charger_capacity")

    def idx = index("UNIQUE_CONNECTION_PER_ACCOUNT", (accountId, connectionId), unique = true)

    override def * = (id, accountId, connectionId, postalCode, longitude, latitude, chargerCapacity, createdAt, lastModified) <> (SmartChargeLocation.tupled, SmartChargeLocation.unapply)
  }

  val smartChargeTableQ: TableQuery[SmartChargeLocations] = TableQuery[SmartChargeLocations]

}
