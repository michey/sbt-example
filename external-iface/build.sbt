name := "external-iface"
scalaVersion := "2.13.7"
organization := "acme"
Compile / unmanagedResourceDirectories += baseDirectory.value / "protobuf"
crossPaths := false
autoScalaLibrary := false

