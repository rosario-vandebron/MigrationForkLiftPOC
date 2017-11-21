// override the default code generator here
trait Codegen extends MyCodegen {
  // set the models requiring code generation here
  //TODO this should be automated in someway
  override def tableNames = List("accounts", "smart_charge_locations")
}
