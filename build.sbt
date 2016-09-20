organization := "com.iservport"

version := "1.0.0.BUILD"

name := "iservport-primesw-dashboard"

scalaVersion := "2.11.8"

sbtVersion := "0.13.9"

mainClass in (Compile, run) := Some("com.iservport.dashboard.Application")

val springBootVersion = "1.4.0.RELEASE"

libraryDependencies ++= Seq(
  "org.scala-lang"             % "scala-library"                    % "2.11.8",
  "org.projectlombok"          % "lombok"                           % "1.16.8",
  "org.springframework.boot"   % "spring-boot-starter-web"          % springBootVersion,
//  "org.springframework.boot"   % "spring-boot-starter-data-jpa"     % springBootVersion,
  "org.springframework.boot"   % "spring-boot-starter-security"     % springBootVersion,
  "org.springframework.boot"   % "spring-boot-starter-freemarker"   % springBootVersion,
  "org.springframework.boot"   % "spring-boot-starter-test"         % springBootVersion % "test",
  "org.springframework.boot"   % "spring-boot-test-autoconfigure"   % springBootVersion % "test",
//  "com.zaxxer" % "HikariCP" % "2.4.3",
  "org.scalactic" %% "scalactic" % "3.0.0"
)
