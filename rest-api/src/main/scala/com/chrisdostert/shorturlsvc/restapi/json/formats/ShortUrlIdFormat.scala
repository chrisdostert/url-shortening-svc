package com.chrisdostert.shorturlsvc.restapi.json.formats

import com.chrisdostert.shorturlsvc.core.models.ShortUrlId
import com.chrisdostert.shorturlsvc.restapi.json.JsonSupport
import spray.json._

object ShortUrlIdFormat
  extends JsonSupport
    with RootJsonFormat[ShortUrlId] {

  override def read(json: JsValue): ShortUrlId = {

    json match {
      case JsString(string) => string
      case _ => throw new IllegalArgumentException(
        s"received invalid URL: ${json.compactPrint}"
      )
    }

  }

  override def write(obj: ShortUrlId): JsValue =
    JsString(obj.toString)

}
