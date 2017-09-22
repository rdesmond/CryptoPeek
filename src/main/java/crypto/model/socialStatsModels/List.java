package crypto.model.socialStatsModels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by aaron on 8/24/17.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class List {

    String url; //: "https://github.com/bitcoinj/bitcoinj",
    String last_update; //: "1503546571",
    int subscribers; //: 199,
    String size; //: "16625",
    String created_at; //: "1384835603",
    String open_pull_issues; //: "21",
    Source source; //: {},
    String language; //: "Java",
    String open_total_issues; //: "206",
    int stars; //: 1388,
    int forks; //: 982,
    String closed_total_issues; //: "125",
    String closed_pull_issues; //: "633",
    String open_issues; //: "11",
    String closed_issues; //: "39",
    Parent parent; //: {},
    String fork; //: "false",
    String last_push; //: "1503416393"

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getLast_update() {
        return last_update;
    }

    public void setLast_update(String last_update) {
        this.last_update = last_update;
    }

    public int getSubscribers() {
        return subscribers;
    }

    public void setSubscribers(int subscribers) {
        this.subscribers = subscribers;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getOpen_pull_issues() {
        return open_pull_issues;
    }

    public void setOpen_pull_issues(String open_pull_issues) {
        this.open_pull_issues = open_pull_issues;
    }

    public Source getSource() {
        return source;
    }

    public void setSource(Source source) {
        this.source = source;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getOpen_total_issues() {
        return open_total_issues;
    }

    public void setOpen_total_issues(String open_total_issues) {
        this.open_total_issues = open_total_issues;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public int getForks() {
        return forks;
    }

    public void setForks(int forks) {
        this.forks = forks;
    }

    public String getClosed_total_issues() {
        return closed_total_issues;
    }

    public void setClosed_total_issues(String closed_total_issues) {
        this.closed_total_issues = closed_total_issues;
    }

    public String getClosed_pull_issues() {
        return closed_pull_issues;
    }

    public void setClosed_pull_issues(String closed_pull_issues) {
        this.closed_pull_issues = closed_pull_issues;
    }

    public String getOpen_issues() {
        return open_issues;
    }

    public void setOpen_issues(String open_issues) {
        this.open_issues = open_issues;
    }

    public String getClosed_issues() {
        return closed_issues;
    }

    public void setClosed_issues(String closed_issues) {
        this.closed_issues = closed_issues;
    }

    public Parent getParent() {
        return parent;
    }

    public void setParent(Parent parent) {
        this.parent = parent;
    }

    public String getFork() {
        return fork;
    }

    public void setFork(String fork) {
        this.fork = fork;
    }

    public String getLast_push() {
        return last_push;
    }

    public void setLast_push(String last_push) {
        this.last_push = last_push;
    }
}
