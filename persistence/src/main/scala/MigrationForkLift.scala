import java.util.UUID

import com.typesafe.scalalogging.LazyLogging
import database.Tables
import database.accountDomain.{Account, SmartChargeLocation}
import slick.jdbc.PostgresProfile

import scala.concurrent.{Await, ExecutionContext, ExecutionContextExecutor}
import scala.concurrent.duration._

object MigrationForkLift extends App with LazyLogging {

//  implicit val ec: ExecutionContextExecutor = ExecutionContext.global
//
//  import slick.jdbc.PostgresProfile.api._
//
//  val firstAccount = Account(id = UUID.fromString("1cf987b9-7c46-40b0-a0d4-5b6a24a05934"), customerReference = Some("2108893"), 1)
//  val mockAccount = Account(id = UUID.fromString("83a68229-088d-4f17-8f40-c908134d8256"), customerReference = Some("2188834"), 1)
//
//  val initInstructionsDev = {
//    DBIO.seq(
//      sqlu"""drop schema if exists "poc" cascade;""",
//      sqlu"""create schema if not exists "poc";""")
//  }
//  val setSchemaAction = sqlu"""set search_path to "poc";"""
//  lazy val schemas: PostgresProfile.DDL =
//    Tables.accountsTableQ.schema ++ Tables.smartChargeTableQ.schema
//
//
//  val db: PostgresProfile.backend.Database = Database.forConfig("postgres")
//
//
//  val initialize = for {
//    _ <- db.run(initInstructionsDev)
//    _ <- db.run(setSchemaAction.andThen(schemas.create))
//    _ <- db.run(setSchemaAction.andThen(Tables.accountsTableQ ++= Seq(firstAccount, mockAccount)))
//    _ <- db.run(setSchemaAction.andThen(Tables.smartChargeTableQ += SmartChargeLocation(UUID.randomUUID, firstAccount.id, "connectio", "1017BW", 11.0, 2323, 2322)))
//
//  } yield None
//
//  try {
//    logger.info("Executing db actions....")
//    Await.result(initialize, 10 seconds)
//    logger.info("Actions executed")
//  } finally {
//    db.close()
//  }

}
