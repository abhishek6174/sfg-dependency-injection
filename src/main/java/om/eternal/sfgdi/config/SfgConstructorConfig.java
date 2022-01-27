package om.eternal.sfgdi.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

import java.util.List;

@ConstructorBinding
@ConfigurationProperties("guru")
public class SfgConstructorConfig {
    private final String username;
    private final String password;
    private final String jdbcurl;
    private final List<String> mylist;

    public SfgConstructorConfig(String username, String password, String jdbcurl, List<String> mylist) {
        this.username = username;
        this.password = password;
        this.jdbcurl = jdbcurl;
        this.mylist = mylist;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getJdbcurl() {
        return jdbcurl;
    }

    public List<String> getMylist() {
        return mylist;
    }
}
