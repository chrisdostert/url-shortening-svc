package com.chrisdostert.shorturlsvc.server

import com.chrisdostert.shorturlsvc.core.tdk.BaseFunSpecTest

class ServerIT extends BaseFunSpecTest {

  describe("starting in current thread") {

    it("should not throw") {

      /** arrange/act/assert **/

      Server.main(Array())

    }

  }

}
