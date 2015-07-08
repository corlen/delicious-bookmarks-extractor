package com.example

import java.io.File

import org.jsoup.Jsoup
import org.jsoup.nodes.Element


object BookmarksNavigator {
  def main(args: Array[String]): Unit = {
    val file = new File(getClass.getResource("/delicious.html").getPath)
    val file2 = new File(getClass.getResource("/delicious-maxsantiago.html").getPath)
    val file3 = new File(getClass.getResource("/bookmarks_8_11_13.html").getPath)

    val htmlFile = Jsoup.parse(file, "UTF-8")
    val htmlFile2 = Jsoup.parse(file2, "UTF-8")
    val htmlFile3 = Jsoup.parse(file3, "UTF-8")

    val links = htmlFile.select("a[href]").toArray
    val links2 = htmlFile2.select("a[href]").toArray
    val links3 = htmlFile3.select("a[href]").toArray
    val linksUnion = links ++ links2 ++ links3

    for(element <- linksUnion){
      val link = element.asInstanceOf[Element]
      val linkHref = link.attr("href")
      val linkText = link.text
      val linkTags = link.attr("tags")

      println(s"Link href: $linkHref \nLink Text: $linkText\nLink Tags: $linkTags\n")
    }

    println(s"Elements quantity: ${linksUnion.length}")

  }
}
