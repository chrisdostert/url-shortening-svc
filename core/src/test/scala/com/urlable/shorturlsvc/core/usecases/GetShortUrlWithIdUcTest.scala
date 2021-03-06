package com.urlable.shorturlsvc.core.usecases

import com.urlable.shorturlsvc.core.tdk.testobjects.ATest
import com.urlable.shorturlsvc.core.tdk.BaseFunSpecTest
import com.urlable.shorturlsvc.dbadapter.DbPort
import org.mockito.Mockito._

import scala.concurrent.Future

class GetShortUrlWithIdUcTest
  extends BaseFunSpecTest {

  describe("execute") {

    it("should invoke dbPort.getShortUrlWithId and return result") {

      /** arrange **/
      val providedShortUrlId = ATest.string.nonEmpty

      val expectedReturnedFutureShortUrlView = Future.successful(ATest.shortUrlView.nonNull)

      val mockDbPort = mock[DbPort]
      when(mockDbPort.getShortUrlWithId(providedShortUrlId))
        .thenReturn(expectedReturnedFutureShortUrlView)

      val objectUnderTest = new GetShortUrlWithIdUc(
        mockDbPort
      )

      /** act **/
      val actualReturnedFutureShortUrlView =
        objectUnderTest
          .execute(providedShortUrlId)

      /** assert **/
      assert(actualReturnedFutureShortUrlView == expectedReturnedFutureShortUrlView)

    }
  }

}
