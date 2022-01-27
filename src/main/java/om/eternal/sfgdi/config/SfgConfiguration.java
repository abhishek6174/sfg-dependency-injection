package om.eternal.sfgdi.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@ConfigurationProperties("guru")
@Configuration
public class SfgConfiguration {
    private String username;
    private String password;
    private String jdbcurl;
    private List<String> mylist;

    public List<String> getMylist() {
        return mylist;
    }

    public void setMylist(List<String> mylist) {
        this.mylist = mylist;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getJdbcurl() {
        return jdbcurl;
    }

    public void setJdbcurl(String jdbcurl) {
        this.jdbcurl = jdbcurl;
    }
}
