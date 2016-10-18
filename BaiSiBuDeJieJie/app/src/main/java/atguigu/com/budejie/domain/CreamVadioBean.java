package atguigu.com.budejie.domain;

import java.util.List;

/**
 * Created by Administrator on 2016/1/13.
 */
public class CreamVadioBean {

    /**
     * vendor : foot
     * count : 2000
     * page : 100
     * maxid : 1452657301
     * maxtime : 1452657301
     */

    private InfoEntity info;
    /**
     * id : 16805208
     * type : 41
     * text : 农业现代化，真好用，我怎么没想到！~
     * user_id : 7705011
     * name : 金龙
     * screen_name : 金龙
     * profile_image : http://qzapp.qlogo.cn/qzapp/100682801/A0C3A46B349EA38F04143B4611CD1306/100
     * created_at : 2016-01-13 17:42:01
     * create_time : 2016-01-08 20:10:02
     * passtime : 2016-01-13 17:42:01
     * love : 1324
     * hate : 153
     * comment : 52
     * repost : 208
     * bookmark : 187
     * bimageuri : http://wimg.spriteapp.cn/picture/2016/0108/568fa71a56060_wpd.jpg
     * voiceuri :
     * voicetime : 0
     * voicelength : 0
     * status : 4
     * theme_id : 0
     * theme_name :
     * theme_type : 0
     * videouri : http://wvideo.spriteapp.cn/video/2016/0108/568fa71a56060_wpd.mp4
     * videotime : 51
     * original_pid : 0
     * cache_version : 2
     * playcount : 31036
     * playfcount : 9601
     * cai : 153
     * top_cmt : []
     * weixin_url : http://a.f.winapp111.com.cn/budejie/land.php?pid=16805208&wx.qq.com&appname=
     * themes : []
     * image1 : http://wimg.spriteapp.cn/picture/2016/0108/568fa71a56060_wpd.jpg
     * image2 : http://wimg.spriteapp.cn/picture/2016/0108/568fa71a56060_wpd.jpg
     * is_gif : 0
     * image0 : http://wimg.spriteapp.cn/picture/2016/0108/568fa71a56060_wpd.jpg
     * image_small : http://wimg.spriteapp.cn/picture/2016/0108/568fa71a56060_wpd.jpg
     * cdn_img : http://wimg.spriteapp.cn/picture/2016/0108/568fa71a56060_wpd.jpg
     * width : 480
     * height : 640
     * tag :
     * t : 1452678121
     * ding : 1324
     * favourite : 187
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
        private int playcount;
        private int playfcount;
        private String cai;
        private String weixin_url;
        private String image1;
        private String image2;
        private String is_gif;
        private String image0;
        private String image_small;
        private String cdn_img;
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

        public void setPlaycount(int playcount) {
            this.playcount = playcount;
        }

        public void setPlayfcount(int playfcount) {
            this.playfcount = playfcount;
        }

        public void setCai(String cai) {
            this.cai = cai;
        }

        public void setWeixin_url(String weixin_url) {
            this.weixin_url = weixin_url;
        }

        public void setImage1(String image1) {
            this.image1 = image1;
        }

        public void setImage2(String image2) {
            this.image2 = image2;
        }

        public void setIs_gif(String is_gif) {
            this.is_gif = is_gif;
        }

        public void setImage0(String image0) {
            this.image0 = image0;
        }

        public void setImage_small(String image_small) {
            this.image_small = image_small;
        }

        public void setCdn_img(String cdn_img) {
            this.cdn_img = cdn_img;
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

        public int getPlaycount() {
            return playcount;
        }

        public int getPlayfcount() {
            return playfcount;
        }

        public String getCai() {
            return cai;
        }

        public String getWeixin_url() {
            return weixin_url;
        }

        public String getImage1() {
            return image1;
        }

        public String getImage2() {
            return image2;
        }

        public String getIs_gif() {
            return is_gif;
        }

        public String getImage0() {
            return image0;
        }

        public String getImage_small() {
            return image_small;
        }

        public String getCdn_img() {
            return cdn_img;
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
