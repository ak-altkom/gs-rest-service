package hello;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author akrol
 */
@FeignClient(value = "cas", url = "localhost:9080")
@RequestMapping("energeia-cas/")
public interface CasClient {

    @RequestMapping(value = "putSessionData", method = RequestMethod.POST, consumes = "application/json")
    @ResponseBody
    String putSessionData(@RequestBody byte[] input);
}
