import com.liyaos.forklift.slick._

object PostgresMigration extends App
    with SlickMigrationCommandLineTool
    with SlickMigrationCommands
    with PostgresMigrationManager
    with Codegen {
  MigrationSummary
  execCommands(args.toList)

  override def execCommands(args: List[String]) = args match {
    case "reset" :: Nil => reset
    case _                => super.execCommands(args)
  }
}
