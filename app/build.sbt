
val Settings: Seq[Def.Setting[_]] = Seq(
  scalaVersion := "2.13.8",
  organization := "acme"
)

def module(path: String): Project = {
  Project(path, file(s"modules/$path"))
    .settings(
      name := path
    )
    .settings(Settings)
}

lazy val exampleProtobuf =
  module("internal-proto")
    .settings(
      PB.protocVersion := "3.17.3",
      crossPaths := false,
      autoScalaLibrary := false,
      libraryDependencies ++= Seq(
        "acme" % "external-iface" % "1.0.0" % "protobuf-src" intransitive(),
        "com.thesamet.scalapb" %% "scalapb-runtime" % scalapb.compiler.Version.scalapbVersion,
        "com.thesamet.scalapb.zio-grpc" %% "zio-grpc-codegen" % "0.5.1"
      ),
      Compile / PB.targets := Seq(
        scalapb.gen() -> (Compile / sourceManaged).value,
        scalapb.zio_grpc.ZioCodeGenerator -> (configuration / sourceManaged).value
      )
    )


lazy val app =
 module("app")
    .dependsOn(exampleProtobuf)