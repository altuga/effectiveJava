/**
 * The MIT License
 * Copyright (c) 2014-2016 Ilkka Seppälä
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package state;

import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.AppenderBase;
import com.kodcu.examples.exceptions.state.SeatSales;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Date: 12/29/15 - 8:27 PM
 *
 * @author Jeroen Meulemeester and Altug Bilgin Altintas
 */
public class SeatSalesTest {

  private InMemoryAppender appender;


  @Before
  public void setUp() {
    appender = new InMemoryAppender();
  }

  @After
  public void tearDown() {
    appender.stop();
  }

  /**
   * Switch to a complete mammoth 'mood'-cycle and verify if the observed mood matches the expected
   * value.
   */
  @Test
  public void testTimePasses() {

    // given
    final SeatSales seatSales = new SeatSales();
    seatSales.observe();
    assertEquals("The Seat Seat is Empty, oley !!", appender.getLastMessage());
    assertEquals(1 , appender.getLogSize());

    // when
    seatSales.timePasses();
    assertEquals("The Seat Seat is Empty, oley !!", appender.getLastMessage());
    assertEquals(1 , appender.getLogSize());

    // then
    seatSales.observe();
    assertEquals("The Seat Seat Is Full, sorry!", appender.getLastMessage());
    assertEquals(2 , appender.getLogSize());

    // when
    seatSales.timePasses();
    assertEquals("The Seat Seat Is Full, sorry!", appender.getLastMessage());
    assertEquals(2 , appender.getLogSize());

    // then
    seatSales.observe();
    assertEquals("The Seat Seat is Empty, oley !!", appender.getLastMessage());
    assertEquals(3 , appender.getLogSize());


    // TODO 1 - Add stress state
    // TODO 2 - if same state entered then throw an Exception
    // TODO 3 - if state is null then throw an Exception




  }

  /**
   * Verify if {@link SeatSales#toString()} gives the expected value
   */
  @Test
  public void testToString() {
    final String toString = new SeatSales().toString();
    assertNotNull(toString);
    assertEquals("The Seat", toString);
  }

  private class InMemoryAppender extends AppenderBase<ILoggingEvent> {
    private List<ILoggingEvent> log = new LinkedList<>();

    public InMemoryAppender() {
      ((Logger) LoggerFactory.getLogger("root")).addAppender(this);
      start();
    }

    @Override
    protected void append(ILoggingEvent eventObject) {
      log.add(eventObject);
    }

    public int getLogSize() {
      return log.size();
    }

    public String getLastMessage() {
      return log.get(log.size() - 1).getFormattedMessage();
    }
  }

}
