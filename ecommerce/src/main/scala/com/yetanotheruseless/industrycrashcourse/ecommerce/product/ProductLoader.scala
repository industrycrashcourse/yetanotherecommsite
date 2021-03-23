package com.yetanotheruseless.industrycrashcourse.ecommerce.product

import java.io.File
import java.nio.file.Files
import java.{lang, util}
import java.lang.{Double => JDouble}
import java.lang.{Integer => JInteger}

import scala.collection.JavaConverters._
import scala.xml.{Elem, XML}

case class ProductMapHolder(map: Map[String, String])

object ProductLoader {

  /**
    * Helper method for Java
    * @param dir to load xml files from
    * @param fileLimit maximum number of files to load
    * @return an iterator over batches of java.util.List's of java.util.Map<String, String> containing Product details
    */
  def loadProductsForJava(dir: String,
                          fileLimit: Int): lang.Iterable[util.List[Product]] = {
    loadProductsDirBatches(dir, Some(fileLimit))
      .map(_.map(productFromMap).asJava)
      .toIterable
      .asJava
  }

  val productFromMap: ProductMapHolder => Product = (pm: ProductMapHolder) => {
    val m = pm.map.withDefaultValue("")
    val p = new Product()
    m.foreach {
      case ("sku", value)  => p.setSku(value)
      case ("name", value) => p.setName(value)
      case ("type", value) => p.setType(value)
      case ("regularPrice", value) if !value.isEmpty =>
        p.setRegularPrice(JDouble.parseDouble(value))
      case ("image", value)            => p.setImage(value)
      case ("mediumImage", value)      => p.setMediumImage(value)
      case ("thumbnailImage", value)   => p.setThumbnailImage(value)
      case ("shortDescription", value) => p.setShortDescription(value.take(255))
      case ("longDescription", value)  => p.setLongDescription(value.take(255))
      case ("salesRankShortTerm", value) if !value.isEmpty =>
        p.setSalesRankLongTerm(JInteger.parseInt(value))
      case ("salesRankMediumTerm", value) if !value.isEmpty =>
        p.setSalesRankMediumTerm(JInteger.parseInt(value))
      case ("salesRankLongTerm", value) if !value.isEmpty =>
        p.setSalesRankLongTerm(JInteger.parseInt(value))
      case ("customerReviewCount", value) if !value.isEmpty =>
        p.setCustomerReviewCount(JInteger.parseInt(value))
      case ("customerReviewAverage", value) if !value.isEmpty =>
        p.setCustomerReviewAverage(JDouble.parseDouble(value))
      case _ => Unit
    }
    p
  }

  def loadProductsDirBatches(dir: String, fileLimit: Option[Int] = None) = {
    val batchIter = Files
      .list(new File(dir).toPath)
      .iterator()
      .asScala
      .map(path => loadProducts(path.toFile).toList)
    fileLimit.map(batchIter.take).getOrElse(batchIter)
  }

  def loadProducts(file: File): Seq[ProductMapHolder] =
    loadProducts(file.getAbsolutePath)

  def loadProducts(path: String): Seq[ProductMapHolder] = {
    val productsXml = XML.loadFile(path)
    loadProductsFromXml(productsXml)
  }

  def loadProductsFromXml(productsXml: Elem) = {
    val products = productsXml \ "product"
    products.map(
      n =>
        ProductMapHolder(n.child.map(child => child.label -> child.text).toMap)
    )
  }
}
