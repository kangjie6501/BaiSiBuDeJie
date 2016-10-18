package atguigu.com.budejie.domain;

import java.util.List;

/**
 * Created by Administrator on 2016/1/12.
 */
public class CreamTalkBean {

    /**
     * vendor : hide.jie.c
     * count : 2000
     * page : 100
     * maxid : 1452465121
     * maxtime : 1452465121
     */

    private InfoEntity info;
    /**
     * id : 16845085
     * type : 29
     * text : 一哥们特能玩，昨夜打麻将到十二点，赢了两千 块。打完后就去了KTV。 叫了几个公主陪唱， 这家伙满嘴酒气地对人家 讲：“你让我亲一口我给你3万” 天真的小姑娘就闭上了眼睛，然后就被哥们亲了一 口，之后手里被塞了一只麻将！
     * user_id : 16498685
     * name :  课桌上刻着我们的青春ゝ
     * screen_name :  课桌上刻着我们的青春ゝ
     * profile_image : http://qzapp.qlogo.cn/qzapp/100336987/14CA0F8F9D9E5172AF74E423C0FA3747/100
     * created_at : 2016-01-12 19:40:22
     * create_time : 2016-01-11 18:53:50
     * passtime : 2016-01-12 19:40:22
     * love : 1130
     * hate : 436
     * comment : 31
     * repost : 22
     * bookmark : 14
     * bimageuri :
     * voiceuri :
     * voicetime : 0
     * voicelength : 0
     * status : 4
     * theme_id : 0
     * theme_name :
     * theme_type : 0
     * videouri :
     * videotime : 0
     * original_pid : 0
     * cache_version : 2
     * cai : 436
     * top_cmt : []
     * weixin_url : http://c.f.budejie.com/budejie/land.php?pid=16845085&wx.qq.com&appname=
     * themes : []
     * width : 0
     * height : 0
     * tag :
     * t : 1452598822
     * ding : 1130
     * favourite : 14
     */

    private List<ListEntity> list;

    public void setInfo(InfoEntity info) {
        this.info = info;
    }

    public void setList(List<ListEntity> list) {
        this.list = list;
    }

    public InfoEntity getInfo() {
        return info;
    }

    public List<ListEntity> getList() {
        return list;
    }

    public static class InfoEntity {
        private String vendor;
        private int count;
        private int page;
        private String maxid;
        private String maxtime;

        public void setVendor(String vendor) {
            this.vendor = vendor;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public void setPage(int page) {
            this.page = page;
        }

        public void setMaxid(String maxid) {
            this.maxid = maxid;
        }

        public void setMaxtime(String maxtime) {
            this.maxtime = maxtime;
        }

        public String getVendor() {
            return vendor;
        }

        public int getCount() {
            return count;
        }

        public int getPage() {
            return page;
        }

        public String getMaxid() {
            return maxid;
        }

        public String getMaxtime() {
            return maxtime;
        }
    }

    public static class ListEntity {
        private String id;
        private String type;
        private String text;
        private String user_id;
        private String name;
        private String screen_name;
        private String profile_image;
        private String created_at;
        private String create_time;
        private String passtime;
        private String love;
        private String hate;
        private String comment;
        private String repost;
        private String bookmark;
        private String bimageuri;
        private String voiceuri;
        private String voicetime;
        private String voicelength;
        private String status;
        private String theme_id;
        private String theme_name;
        private String theme_type;
        private String videouri;
        private String videotime;
        private String original_pid;
        private int cache_version;
        private String cai;
        private String weixin_url;
        private String width;
        private String height;
        private String tag;
        private int t;
        private String ding;
        private String favourite;
        private List<?> top_cmt;
        private List<?> themes;

        public void setId(String id) {
            this.id = id;
        }

        public void setType(String type) {
            this.type = type;
        }

        public void setText(String text) {
            this.text = text;
        }

        public void setUser_id(String user_id) {
            this.user_id = user_id;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setScreen_name(String screen_name) {
            this.screen_name = screen_name;
        }

        public void setProfile_image(String profile_image) {
            this.profile_image = profile_image;
        }

        public void setCreated_at(String created_at) {
            this.created_at = created_at;
        }

        public void setCreate_time(String create_time) {
            this.create_time = create_time;
        }

        public void setPasstime(String passtime) {
            this.passtime = passtime;
        }

        public void setLove(String love) {
            this.love = love;
        }

        public void setHate(String hate) {
            this.hate = hate;
        }

        public void setComment(String comment) {
            this.comment = comment;
        }

        public void setRepost(String repost) {
            this.repost = repost;
        }

        public void setBookmark(String bookmark) {
            this.bookmark = bookmark;
        }

        public void setBimageuri(String bimageuri) {
            this.bimageuri = bimageuri;
        }

        public void setVoiceuri(String voiceuri) {
            this.voiceuri = voiceuri;
        }

        public void setVoicetime(String voicetime) {
            this.voicetime = voicetime;
        }

        public void setVoicelength(String voicelength) {
            this.voicelength = voicelength;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public void setTheme_id(String theme_id) {
            this.theme_id = theme_id;
        }

        public void setTheme_name(String theme_name) {
            this.theme_name = theme_name;
        }

        public void setTheme_type(String theme_type) {
            this.theme_type = theme_type;
        }

        public void setVideouri(String videouri) {
            this.videouri = videouri;
        }

        public void setVideotime(String videotime) {
            this.videotime = videotime;
        }

        public void setOriginal_pid(String original_pid) {
            this.original_pid = original_pid;
        }

        public void setCache_version(int cache_version) {
            this.cache_version = cache_version;
        }

        public void setCai(String cai) {
            this.cai = cai;
        }

        public void setWeixin_url(String weixin_url) {
            this.weixin_url = weixin_url;
        }

        public void setWidth(String width) {
            this.width = width;
        }

        public void setHeight(String height) {
            this.height = height;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public void setT(int t) {
            this.t = t;
        }

        public void setDing(String ding) {
            this.ding = ding;
        }

        public void setFavourite(String favourite) {
            this.favourite = favourite;
        }

        public void setTop_cmt(List<?> top_cmt) {
            this.top_cmt = top_cmt;
        }

        public void setThemes(List<?> themes) {
            this.themes = themes;
        }

        public String getId() {
            return id;
        }

        public String getType() {
            return type;
        }

        public String getText() {
            return text;
        }

        public String getUser_id() {
            return user_id;
        }

        public String getName() {
            return name;
        }

        public String getScreen_name() {
            return screen_name;
        }

        public String getProfile_image() {
            return profile_image;
        }

        public String getCreated_at() {
            return created_at;
        }

        public String getCreate_time() {
            return create_time;
        }

        public String getPasstime() {
            return passtime;
        }

        public String getLove() {
            return love;
        }

        public String getHate() {
            return hate;
        }

        public String getComment() {
            return comment;
        }

        public String getRepost() {
            return repost;
        }

        public String getBookmark() {
            return bookmark;
        }

        public String getBimageuri() {
            return bimageuri;
        }

        public String getVoiceuri() {
            return voiceuri;
        }

        public String getVoicetime() {
            return voicetime;
        }

        public String getVoicelength() {
            return voicelength;
        }

        public String getStatus() {
            return status;
        }

        public String getTheme_id() {
            return theme_id;
        }

        public String getTheme_name() {
            return theme_name;
        }

        public String getTheme_type() {
            return theme_type;
        }

        public String getVideouri() {
            return videouri;
        }

        public String getVideotime() {
            return videotime;
        }

        public String getOriginal_pid() {
            return original_pid;
        }

        public int getCache_version() {
            return cache_version;
        }

        public String getCai() {
            return cai;
        }

        public String getWeixin_url() {
            return weixin_url;
        }

        public String getWidth() {
            return width;
        }

        public String getHeight() {
            return height;
        }

        public String getTag() {
            return tag;
        }

        public int getT() {
            return t;
        }

        public String getDing() {
            return ding;
        }

        public String getFavourite() {
            return favourite;
        }

        public List<?> getTop_cmt() {
            return top_cmt;
        }

        public List<?> getThemes() {
            return themes;
        }
    }
}
