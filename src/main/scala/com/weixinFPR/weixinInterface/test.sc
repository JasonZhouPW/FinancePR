import org.jsoup.Jsoup

val doc =  Jsoup.connect("https://list.lu.com/list/dingqi").get()

val test = doc.getElementsByClass("product-info")
(0  to test.size()).foreach(
  test.get(_)
)
