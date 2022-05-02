
addSbtPlugin(("com.thesamet" % "sbt-protoc" % "1.0.6").withIsForce(true))

//addSbtPlugin("com.whisk" % "whisk-sbt-plugin" % "6.6.6-SNAPSHOT")

libraryDependencies += "com.thesamet.scalapb.zio-grpc" %% "zio-grpc-codegen" % "0.5.1"