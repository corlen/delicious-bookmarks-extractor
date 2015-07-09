package bookmarksnavigator

import java.io.File

import org.jsoup.Jsoup
import org.jsoup.nodes.Element
import org.jsoup.select.Elements


object BookmarksNavigator {
  def main(args: Array[String]): Unit = {

    val files = args.map { arg =>
      new File(getClass.getResource(arg).getPath)
    }

    val htmlFiles = files.map { file =>
      Jsoup.parse(file, "UTF-8")
    }

    val aTags = htmlFiles.map { htmlFile =>
      val elements: Elements = htmlFile.select("a[href]")
      elements
    }

    for(elements <- aTags){
      for(element <- elements.toArray){
        val link = element.asInstanceOf[Element]
        val linkText = link.text
        val linkHref = link.attr("href")
        val linkTags = link.attr("tags")

        println(s"Link href: $linkHref \nLink Text: $linkText\nLink Tags: $linkTags\n")
      }
    }
  }

}
