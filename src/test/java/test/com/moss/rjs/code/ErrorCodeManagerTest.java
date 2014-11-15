package test.com.moss.rjs.code;

import org.junit.Assert;
import org.junit.Test;

import com.moss.rjs.code.AdminErrorCode;
import com.moss.rjs.code.ErrorCode;
import com.moss.rjs.code.ErrorCodeManager;
import com.moss.rjs.code.TicketErrorCode;

public class ErrorCodeManagerTest {

    @Test
    public void getErrorCode() {
        // Arrange
        ErrorCodeManager manager = new ErrorCodeManager();
        manager.addErrorCode(AdminErrorCode.class);
        int code = 2;
        
        // Act
        ErrorCode<?> errorCode = manager.getErrorCode(code);
        
        // Assert
        Assert.assertEquals(code, errorCode.getCode());
        Assert.assertEquals(AdminErrorCode.BBB, errorCode);
        Assert.assertEquals("AdminErrorCode.BBB", errorCode.getClass().getSimpleName() + "." + errorCode.name());
        
    }
    
    @Test
    public void getErrorCode_multiErrorCode() {
        // Arrange
        ErrorCodeManager manager = new ErrorCodeManager();
        manager.addErrorCode(AdminErrorCode.class);
        manager.addErrorCode(TicketErrorCode.class);
        int adminErrorCode = 2;
        int ticketErrorCode = 1001;
        
        // Act
        ErrorCode<?> adminErrorCodeResult = manager.getErrorCode(adminErrorCode);
        ErrorCode<?> ticketErrorCodeResult = manager.getErrorCode(ticketErrorCode);
        
        // Assert
        Assert.assertEquals(adminErrorCode, adminErrorCodeResult.getCode());
        Assert.assertEquals(AdminErrorCode.BBB, adminErrorCodeResult);
        Assert.assertEquals("AdminErrorCode.BBB", adminErrorCodeResult.getClass().getSimpleName() + "." + adminErrorCodeResult.name());
        
        Assert.assertEquals(ticketErrorCode, ticketErrorCodeResult.getCode());
        Assert.assertEquals(TicketErrorCode.DDD, ticketErrorCodeResult);
        Assert.assertEquals("TicketErrorCode.DDD", ticketErrorCodeResult.getClass().getSimpleName() + "." + ticketErrorCodeResult.name());
    }
}
