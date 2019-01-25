/**
 * Pesaway Pesamoni API Documentation
 * No description provided (generated by Swagger Codegen https://github.com/swagger-api/swagger-codegen)
 *
 * OpenAPI spec version: 1.0.3
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package io.swagger.client

import com.sun.jersey.api.client.Client
import com.sun.jersey.api.client.ClientResponse
import com.sun.jersey.api.client.config.ClientConfig
import com.sun.jersey.api.client.config.DefaultClientConfig
import com.sun.jersey.api.client.filter.LoggingFilter

import com.sun.jersey.core.util.MultivaluedMapImpl
import com.sun.jersey.multipart.FormDataMultiPart
import com.sun.jersey.multipart.file.FileDataBodyPart

import java.io.File
import java.net.URLEncoder
import java.util.UUID
import javax.ws.rs.core.MediaType

import scala.collection.JavaConverters._
import scala.collection.mutable

import com.fasterxml.jackson.module.scala.DefaultScalaModule
import com.fasterxml.jackson.datatype.joda.JodaModule
import com.fasterxml.jackson.core.JsonGenerator.Feature
import com.fasterxml.jackson.databind._
import com.fasterxml.jackson.annotation._
import com.fasterxml.jackson.databind.annotation.JsonSerialize

object ScalaJsonUtil {
  def getJsonMapper: ObjectMapper = {
    val mapper = new ObjectMapper()
    mapper.registerModule(new DefaultScalaModule())
    mapper.registerModule(new JodaModule())
    mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL)
    mapper.setSerializationInclusion(JsonInclude.Include.NON_DEFAULT)
    mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false)
    mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
    mapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY)
    mapper
  }
}

class ApiInvoker(val mapper: ObjectMapper = ScalaJsonUtil.getJsonMapper,
  httpHeaders: mutable.HashMap[String, String] = mutable.HashMap(),
  hostMap: mutable.HashMap[String, Client] = mutable.HashMap(),
  asyncHttpClient: Boolean = false,
  authScheme: String = "",
  authPreemptive: Boolean = false
) {

  var defaultHeaders: mutable.HashMap[String, String] = httpHeaders

  def escape(value: String): String = {
    URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")
  }
  def escape(values: List[String]): String = {
     values.map(escape).mkString(",")
  }

  def escape(value: Long): String = value.toString
  def escape(value: Double): String = value.toString
  def escape(value: Float): String = value.toString
  def escape(value: UUID): String = value.toString

  def deserialize(json: String, containerType: String, cls: Class[_]) = {
    if (cls == classOf[String]) {
      json match {
        case s: String =>
          if (s.startsWith("\"") && s.endsWith("\"") && s.length > 1) {
            s.substring(1, s.length - 1)
          } else {
            s
          }
        case _ => null
      }
    } else {
      containerType.toLowerCase match {
        case "array" =>
          val typeInfo = mapper.getTypeFactory.constructCollectionType(classOf[java.util.List[_]], cls)
          val response = mapper.readValue(json, typeInfo).asInstanceOf[java.util.List[_]]
          response.asScala.toList
        case "list" =>
          val typeInfo = mapper.getTypeFactory.constructCollectionType(classOf[java.util.List[_]], cls)
          val response = mapper.readValue(json, typeInfo).asInstanceOf[java.util.List[_]]
          response.asScala.toList
        case _ =>
          json match {
            case e: String if "\"\"" == e => null
            case _ => mapper.readValue(json, cls)
          }
      }
    }
  }

  def serialize(obj: AnyRef): String = {
    if (obj != null) {
      obj match {
        case e: List[_] => mapper.writeValueAsString(obj.asInstanceOf[List[_]].asJava)
        case _ => mapper.writeValueAsString(obj)
      }
    } else {
        null
    }
  }

  def invokeApi(
    host: String,
    path: String,
    method: String,
    queryParams: Map[String, String],
    formParams: Map[String, String],
    body: AnyRef,
    headerParams: Map[String, String],
    contentType: String
): String = {
    val client = getClient(host)

    val querystring = queryParams.filter(k => k._2 != null).map(k => escape(k._1) + "=" + escape(k._2)).mkString("?", "&", "")
    val builder = client.resource(host + path + querystring).accept(contentType)
    headerParams.map(p => builder.header(p._1, p._2))
    defaultHeaders.foreach(p => {
      if (!headerParams.contains(p._1) && p._2 != null) {
        builder.header(p._1, p._2)
      }
    })
    var formData: MultivaluedMapImpl = null
    if (contentType == "application/x-www-form-urlencoded") {
      formData = new MultivaluedMapImpl()
      formParams.foreach(p => formData.add(p._1, p._2))
    }

    val response: ClientResponse = method match {
      case "GET" => builder.get(classOf[ClientResponse])
      case "POST" =>
        if (formData != null && formData.size() > 0) {
            builder.post(classOf[ClientResponse], formData)
        } else if (body != null && body.isInstanceOf[File]) {
          val file = body.asInstanceOf[File]
          val form = new FormDataMultiPart()
          form.field("filename", file.getName)
          form.bodyPart(new FileDataBodyPart("file", file, MediaType.MULTIPART_FORM_DATA_TYPE))
          builder.post(classOf[ClientResponse], form)
        } else {
          if (body == null) {
            builder.post(classOf[ClientResponse], serialize(body))
          } else {
            builder.`type`(contentType).post(classOf[ClientResponse], serialize(body))
          }
        }
      case "PUT" =>
        if (formData != null) {
            builder.post(classOf[ClientResponse], formData)
        } else if (body == null) {
            builder.put(classOf[ClientResponse], null)
        } else {
            builder.`type`(contentType).put(classOf[ClientResponse], serialize(body))
        }
      case "DELETE" => builder.delete(classOf[ClientResponse])
      case "PATCH" =>
        if(formData != null) {
          builder.header("X-HTTP-Method-Override", "PATCH").post(classOf[ClientResponse], formData)
        } else if(body == null) {
          builder.header("X-HTTP-Method-Override", "PATCH").post(classOf[ClientResponse], null)
        } else {
          builder.header("X-HTTP-Method-Override", "PATCH").`type`(contentType).post(classOf[ClientResponse], serialize(body))
        }
      case _ => null
    }
    response.getStatusInfo.getStatusCode match {
      case 204 => ""
      case code: Int if Range(200, 299).contains(code) =>
        if (response.hasEntity) {
          response.getEntity(classOf[String])
        } else {
          ""
        }
      case _ =>
        val entity = if (response.hasEntity) {
          response.getEntity(classOf[String])
        } else {
          "no data"
        }
        throw new ApiException(response.getStatusInfo.getStatusCode, entity)
    }
  }

  def getClient(host: String): Client = {
    if (hostMap.contains(host)) {
      hostMap(host)
    } else {
      val client = newClient(host)
      // client.addFilter(new LoggingFilter())
      hostMap += host -> client
      client
    }
  }

  def newClient(host: String): Client = if (asyncHttpClient) {
    import com.ning.http.client.Realm
    import org.sonatype.spice.jersey.client.ahc.AhcHttpClient
    import org.sonatype.spice.jersey.client.ahc.config.DefaultAhcConfig

    val config: DefaultAhcConfig = new DefaultAhcConfig()
    if (!authScheme.isEmpty) {
      val authSchemeEnum = Realm.AuthScheme.valueOf(authScheme)
      config
        .getAsyncHttpClientConfigBuilder
        .setRealm(new Realm.RealmBuilder().setScheme(authSchemeEnum)
        .setUsePreemptiveAuth(authPreemptive).build)
    }
    AhcHttpClient.create(config)
  } else {
     Client.create()
  }
}

object ApiInvoker extends ApiInvoker(
  mapper = ScalaJsonUtil.getJsonMapper,
  httpHeaders = mutable.HashMap(),
  hostMap = mutable.HashMap(),
  asyncHttpClient = false,
  authScheme = "",
  authPreemptive = false
)

class ApiException(val code: Int, msg: String) extends RuntimeException(msg)
