organization := "com.iservport"

lazy val root = (project in file("."))
  .enablePlugins(JavaServerAppPackaging)
  .enablePlugins(DockerPlugin)
  .settings(
    name := "iservport-primesw-dashboard",
    mainClass in (Compile) := Some("com.iservport.dashboard.Application"),
    version := "1.2.6.RELEASE",
    dockerBaseImage := "azul/zulu-openjdk:8",
    dockerUpdateLatest := true,
    dockerExposedPorts := Seq(8080),
    dockerExposedVolumes := Seq("/opt/data"),
    dockerRepository := Some("iservport")
  )

scalaVersion := "2.11.8"

sbtVersion := "0.13.9"

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
//  "com.fasterxml.jackson.module" %% "jackson-module-scala" % "2.7.2",
//  "com.zaxxer" % "HikariCP" % "2.4.3",
  "org.scalactic" %% "scalactic" % "3.0.0",
  "org.scalatest" %% "scalatest" % "3.0.0" % "test",
  "org.mockito" % "mockito-all" % "1.10.19" % "test"
)

// client-side deps
libraryDependencies ++= Seq(
  "org.webjars.bower" % "angular"              % "1.5.8",
  "org.webjars.bower" % "angular-sanitize"     % "1.5.8",
  "org.webjars.bower" % "angular-resource"     % "1.5.8",
  "org.webjars.bower" % "angular-animate"      % "1.5.8",
  "org.webjars.bower" % "angular-i18n"         % "1.5.8",
  "org.webjars.bower" % "bootstrap"            % "3.3.7"  exclude("org.webjars.bower", "jquery"),
  "org.webjars.bower" % "jquery"               % "2.2.4",
  "org.webjars.bower" % "fontawesome"          % "4.6.3",
  "org.webjars.bower" % "angular-google-chart" % "0.1.0",
  "org.webjars.bower" % "angularpoller"        % "0.3.2"
)
