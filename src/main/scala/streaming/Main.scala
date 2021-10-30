package streaming

import fs2.{Stream, text}
import fs2.io.file.Files
import fs2.io.file.Path
import cats.effect.{ExitCode, IO, IOApp}



object Main extends IOApp {
  override def run(args: List[String]): IO[ExitCode] = {
    myStream.compile.drain.as(ExitCode.Success)
  }

  def createDirectory(name: String) =  {
    Files[IO]
      .createFile(Path(s"./${name}"))
  }

  def createFile(fileName: String) = {
    Files[IO].createFile(Path(fileName))
  }

  def writeToFile(dirName: String, fileName: String) = {
    for {
      _ <- createDirectory(dirName)
      _ <- createFile(s"${dirName}/${fileName}")
    } yield ()
  }

  def myStream: Stream[IO, String] =  {
    Stream[IO, String]("name", "Sam", "Yaaa", "RandomName", "Benson")
      .repeat.take(19)
      .intersperse("\n")
      .through(text.utf8.encode)
      .evalTap(eachByte => IO.println(s"Each byte ${eachByte}"))
      .through(text.utf8.decode)
      .evalTap(eachString => IO.println(s"Each String ${eachString}"))
      .through(text.utf8.encode)
      .through(Files[IO].writeAll(Path("./a.txt")))
  }

  def textLine =
    Stream
      .emit("This text spawns \n more \n than \n one \n line")
      .through(text.lines)
      .compile
      .toList

  def workingOne = {
      Stream[IO, String]("name", "Samm", "Yaaa", "RandomName", "Benson")
        .repeat.take(19)
        .intersperse("\n")
        .through(text.utf8.encode)
        .evalTap(IO.println)
        .through(text.utf8.decode)
        .through(text.utf8.encode)
        .through(Files[IO].writeAll(Path("./a.txt")))

  }


}