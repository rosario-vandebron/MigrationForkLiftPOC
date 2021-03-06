import com.liyaos.forklift.slick._

object PostgresMigration extends App
    with SlickMigrationCommandLineTool
    with SlickMigrationCommands
    with PostgresMigrationManager
    with Codegen {
  MigrationSummary
  execCommands(args.toList)

  override def resetCommand(): Unit ={
    try{
      reset
    }finally {
      db.close()
    }
  }
}
