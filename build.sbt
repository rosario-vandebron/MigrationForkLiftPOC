
name := "MigrationForkLiftPOC"


version := "1.0"

scalaVersion := "2.11.8"

scalacOptions ++= Seq(
  "-target:jvm-1.8",         // target jvm
  "-encoding", "UTF-8",      // source is in utf8
  "-unchecked",              // provide more info about type erasure
  "-deprecation",            // warn about deprecated usage
  "-feature",                // provide information about misused language features
  "-Xfuture",                // warn about upcoming compiler changes eg. deprecations
  "-Ywarn-dead-code",        // warn about unreachable code
  // "-Ywarn-numeric-widen",    // warn when numeric types are widened eg. float to double
  "-Ywarn-unused"            // warn about unused code
)


/*******************************************
  * migration BEGIN
  *****************************************/

addCommandAlias("mgm", "migration_manager/run")
addCommandAlias("mg", "migrations/run")
lazy val forkliftVersion = "0.3.1"
lazy val commonSettings = Seq(
  version := "1.0",
  scalaVersion := "2.11.8",
  scalacOptions += "-deprecation",
  scalacOptions += "-feature",
  resolvers ++= Seq(
    Resolver.bintrayRepo("naftoligug", "maven"),
    Resolver.jcenterRepo,
    Resolver.sonatypeRepo("snapshots"))
)

lazy val forkliftDependencies = List(
  "com.liyaos" %% "scala-forklift-slick" % forkliftVersion,
  "io.github.nafg" %% "slick-migration-api" % "0.4.2"
)


lazy val migrationsDependencies =
  db ++ forkliftDependencies ++ logging

lazy val migrationManagerDependencies = db ++ forkliftDependencies



lazy val migrationManager = Project("migration_manager",
  file("migration_manager")).settings(
  commonSettings:_*).settings {
  libraryDependencies ++= migrationManagerDependencies
}

lazy val migrations = (project in file("migrations"))
  .dependsOn(migrationManager, persistence)
  .settings(commonSettings:_*)
  .settings {
  libraryDependencies ++= migrationsDependencies
}

//lazy val tools = (project in file("tools/git"))
//  .settings(commonSettings:_*)
//  .settings {
//  libraryDependencies ++= forkliftDependencies ++ List(
//    "com.liyaos" %% "scala-forklift-git-tools" % forkliftVersion,
//    "com.typesafe" % "config" % "1.3.0",
//    "org.eclipse.jgit" % "org.eclipse.jgit" % "4.0.1.201506240215-r"
//  )
//}


lazy val generatedCode = (project in file("generated_code"))
  .settings(commonSettings:_*).settings {
  libraryDependencies ++= slick
}

/*******************************************
  * migration END
  *****************************************/

// persistence
lazy val phantomVersion          = "2.13.4"
lazy val slickVersion            = "3.2.1"
lazy val postgresVersion         = "9.1-901-1.jdbc4"
lazy val typesafeConfigVersion   = "1.3.1"

// logging
lazy val scalaLoggingVersion     = "3.5.0"
lazy val logbackVersion          = "1.2.3"
lazy val gelfVersion             = "1.1.11"

// testing
lazy val scalatestVersion        = "3.0.3"
lazy val mockitoVersion          = "1.10.19"
lazy val jUnitVersion            = "4.12"


lazy val db = Seq(
  "org.postgresql" % "postgresql" % "42.1.4",
  "com.typesafe.slick" %% "slick-hikaricp" % slickVersion
)


lazy val slick = Seq(
  "com.typesafe.slick" %% "slick" % slickVersion
)

lazy val typesafeConfig = Seq(
  "com.typesafe" % "config" % typesafeConfigVersion
)

lazy val logging = Seq(
  "com.typesafe.scala-logging" %% "scala-logging" % scalaLoggingVersion,
  "ch.qos.logback" % "logback-classic" % logbackVersion,
  "com.github.pukkaone" % "logback-gelf" % gelfVersion
)

lazy val scalatest = Seq(
  "org.mockito"       % "mockito-all"        % mockitoVersion % Test,
  "org.scalatest"     %% "scalatest"         % scalatestVersion % Test,
  "junit"             % "junit"             % jUnitVersion % Test
)

lazy val persistence = (project in file("persistence"))
  .settings(commonSettings:_*)
  .settings(mainClass in Compile := Some("MigrationForkLift"))
  .settings {
  libraryDependencies ++= persistenceDependency
}

lazy val persistenceDependency = typesafeConfig ++ logging ++ slick ++ db ++ scalatest

lazy val root = (project in file(".")).
  settings(parallelExecution in Test := false)