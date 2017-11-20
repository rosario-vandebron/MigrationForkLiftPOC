package datamodel.v1.schema
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
  lazy val schema: profile.SchemaDescription = Accounts.schema ++ Accounts.schema
  @deprecated("Use .schema instead of .ddl", "3.0")
  def ddl = schema

  /** Entity class storing rows of table Accounts
   *  @param id Database column id SqlType(uuid), PrimaryKey
   *  @param customerReference Database column customer_reference SqlType(varchar), Default(None)
   *  @param createdAt Database column created_at SqlType(timestamp), Default(None)
   *  @param lastModified Database column last_modified SqlType(timestamp), Default(None) */
  case class AccountsRow(id: java.util.UUID, customerReference: Option[String] = None, createdAt: Option[java.sql.Timestamp] = None, lastModified: Option[java.sql.Timestamp] = None)
  /** GetResult implicit for fetching AccountsRow objects using plain SQL queries */
  implicit def GetResultAccountsRow(implicit e0: GR[java.util.UUID], e1: GR[Option[String]], e2: GR[Option[java.sql.Timestamp]]): GR[AccountsRow] = GR{
    prs => import prs._
    AccountsRow.tupled((<<[java.util.UUID], <<?[String], <<?[java.sql.Timestamp], <<?[java.sql.Timestamp]))
  }
  /** Table description of table accounts. Objects of this class serve as prototypes for rows in queries. */
  class Accounts(_tableTag: Tag) extends profile.api.Table[AccountsRow](_tableTag, Some("poc"), "accounts") {
    def * = (id, customerReference, createdAt, lastModified) <> (AccountsRow.tupled, AccountsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), customerReference, createdAt, lastModified).shaped.<>({r=>import r._; _1.map(_=> AccountsRow.tupled((_1.get, _2, _3, _4)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(uuid), PrimaryKey */
    val id: Rep[java.util.UUID] = column[java.util.UUID]("id", O.PrimaryKey)
    /** Database column customer_reference SqlType(varchar), Default(None) */
    val customerReference: Rep[Option[String]] = column[Option[String]]("customer_reference", O.Default(None))
    /** Database column created_at SqlType(timestamp), Default(None) */
    val createdAt: Rep[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("created_at", O.Default(None))
    /** Database column last_modified SqlType(timestamp), Default(None) */
    val lastModified: Rep[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("last_modified", O.Default(None))

    /** Uniqueness Index over (customerReference) (database name accounts_customer_reference_key) */
    val index1 = index("accounts_customer_reference_key", customerReference, unique=true)
  }
  /** Collection-like TableQuery object for table Accounts */
  lazy val Accounts = new TableQuery(tag => new Accounts(tag))

  /** Entity class storing rows of table Accounts
   *  @param id Database column id SqlType(uuid), PrimaryKey
   *  @param customerReference Database column customer_reference SqlType(varchar), Default(None)
   *  @param test Database column test SqlType(int4)
   *  @param createdAt Database column created_at SqlType(timestamp), Default(None)
   *  @param lastModified Database column last_modified SqlType(timestamp), Default(None) */
  case class AccountsRow(id: java.util.UUID, customerReference: Option[String] = None, test: Int, createdAt: Option[java.sql.Timestamp] = None, lastModified: Option[java.sql.Timestamp] = None)
  /** GetResult implicit for fetching AccountsRow objects using plain SQL queries */
  implicit def GetResultAccountsRow(implicit e0: GR[java.util.UUID], e1: GR[Option[String]], e2: GR[Int], e3: GR[Option[java.sql.Timestamp]]): GR[AccountsRow] = GR{
    prs => import prs._
    AccountsRow.tupled((<<[java.util.UUID], <<?[String], <<[Int], <<?[java.sql.Timestamp], <<?[java.sql.Timestamp]))
  }
  /** Table description of table accounts. Objects of this class serve as prototypes for rows in queries. */
  class Accounts(_tableTag: Tag) extends profile.api.Table[AccountsRow](_tableTag, "accounts") {
    def * = (id, customerReference, test, createdAt, lastModified) <> (AccountsRow.tupled, AccountsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), customerReference, Rep.Some(test), createdAt, lastModified).shaped.<>({r=>import r._; _1.map(_=> AccountsRow.tupled((_1.get, _2, _3.get, _4, _5)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(uuid), PrimaryKey */
    val id: Rep[java.util.UUID] = column[java.util.UUID]("id", O.PrimaryKey)
    /** Database column customer_reference SqlType(varchar), Default(None) */
    val customerReference: Rep[Option[String]] = column[Option[String]]("customer_reference", O.Default(None))
    /** Database column test SqlType(int4) */
    val test: Rep[Int] = column[Int]("test")
    /** Database column created_at SqlType(timestamp), Default(None) */
    val createdAt: Rep[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("created_at", O.Default(None))
    /** Database column last_modified SqlType(timestamp), Default(None) */
    val lastModified: Rep[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("last_modified", O.Default(None))

    /** Uniqueness Index over (customerReference) (database name accounts_customer_reference_key) */
    val index1 = index("accounts_customer_reference_key", customerReference, unique=true)
  }
  /** Collection-like TableQuery object for table Accounts */
  lazy val Accounts = new TableQuery(tag => new Accounts(tag))
}
object Version{
  def version = 1
}
