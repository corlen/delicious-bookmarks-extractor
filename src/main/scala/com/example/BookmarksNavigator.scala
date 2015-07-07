package com.example

import java.io.File

import org.jsoup.Jsoup


object BookmarksNavigator {
  def main(args: Array[String]): Unit = {
    val file = new File(getClass.getResource("/delicious.html").getPath)

    val htmlFile = Jsoup.parse(file, "UTF-8")

    val title = htmlFile.title
    val aElements = htmlFile.getElementsByTag("a").toArray

    for(element <- aElements){
      println("Element: " + element.toString)
    }

    println(s"Title: $title and elements quantity: ${aElements.length}")

  }
}
