package datamodel.v3.schema
// AUTO-GENERATED Slick data model
/** Stand-alone Slick data model for immediate use */
object tables extends {
  val profile = slick.jdbc.PostgresProfile
} with tables

/** Slick data model trait for extension, choice of backend or usage in the cake pattern. (Make sure to initialize this late.) */
trait tables {
  val profile: slick.jdbc.JdbcProfile
  import profile.api._
  import slick.model.ForeignKeyAction
  // NOTE: GetResult mappers for plain SQL are only generated for tables where Slick knows how to map the types of all columns.
  import slick.jdbc.{GetResult => GR}

  /** DDL for all tables. Call .create to execute. */
  lazy val schema: profile.SchemaDescription = Accounts.schema ++ SmartChargeLocations.schema
  @deprecated("Use .schema instead of .ddl", "3.0")
  def ddl = schema

  /** Entity class storing rows of table Accounts
   *  @param id Database column id SqlType(uuid), PrimaryKey */
  case class AccountsRow(id: java.util.UUID)
  /** GetResult implicit for fetching AccountsRow objects using plain SQL queries */
  implicit def GetResultAccountsRow(implicit e0: GR[java.util.UUID]): GR[AccountsRow] = GR{
    prs => import prs._
    AccountsRow(<<[java.util.UUID])
  }
  /** Table description of table accounts. Objects of this class serve as prototypes for rows in queries. */
  class Accounts(_tableTag: Tag) extends profile.api.Table[AccountsRow](_tableTag, Some("bigd_ev"), "accounts") {
    def * = id <> (AccountsRow, AccountsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = Rep.Some(id).shaped.<>(r => r.map(_=> AccountsRow(r.get)), (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(uuid), PrimaryKey */
    val id: Rep[java.util.UUID] = column[java.util.UUID]("id", O.PrimaryKey)
  }
  /** Collection-like TableQuery object for table Accounts */
  lazy val Accounts = new TableQuery(tag => new Accounts(tag))

  /** Entity class storing rows of table SmartChargeLocations
   *  @param id Database column id SqlType(uuid), PrimaryKey */
  case class SmartChargeLocationsRow(id: java.util.UUID)
  /** GetResult implicit for fetching SmartChargeLocationsRow objects using plain SQL queries */
  implicit def GetResultSmartChargeLocationsRow(implicit e0: GR[java.util.UUID]): GR[SmartChargeLocationsRow] = GR{
    prs => import prs._
    SmartChargeLocationsRow(<<[java.util.UUID])
  }
  /** Table description of table smart_charge_locations. Objects of this class serve as prototypes for rows in queries. */
  class SmartChargeLocations(_tableTag: Tag) extends profile.api.Table[SmartChargeLocationsRow](_tableTag, Some("bigd_ev"), "smart_charge_locations") {
    def * = id <> (SmartChargeLocationsRow, SmartChargeLocationsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = Rep.Some(id).shaped.<>(r => r.map(_=> SmartChargeLocationsRow(r.get)), (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(uuid), PrimaryKey */
    val id: Rep[java.util.UUID] = column[java.util.UUID]("id", O.PrimaryKey)
  }
  /** Collection-like TableQuery object for table SmartChargeLocations */
  lazy val SmartChargeLocations = new TableQuery(tag => new SmartChargeLocations(tag))
}
object Version{
  def version = 3
}
