package com.joulebug.readability;

/**
 * Created with IntelliJ IDEA.
 * User: josephelliott
 * Date: 12/19/13
 * Time: 10:31
 * To change this template use File | Settings | File Templates.
 */

/*
{
    "content" <div class=\"article-text\">\n<p>I'm idling outside Diamante's, [snip] ...</p></div>",
    "domain": "www.gq.com",
    "author": "Rafi Kohan",
    "url": "http://www.gq.com/sports/profiles/201202/david-diamante-interview-cigar-lounge-brooklyn-new-jersey-nets?currentPage=all",
    "short_url": "http://rdd.me/g3jcb1sr",
    "title": "Blowing Smoke with Boxing's Big Voice",
    "excerpt": "I'm idling outside Diamante's, a cigar lounge in Fort Greene, waiting for David Diamante, and soon I smell him coming. It's late January but warm. A motorcycle growls down the Brooklyn side street,&hellip;",
    "direction": "ltr",
    "word_count": 2892,
    "total_pages": 1,
    "date_published": null,
    "dek": "Announcer <strong>David Diamante</strong>, the new voice of the New Jersey (soon Brooklyn) Nets, has been calling boxing matches for years. On the side, he owns a cigar lounge in the heart of Brooklyn. We talk with Diamante about his new gig and the fine art of cigars",
    "lead_image_url": "http://www.gq.com/images/entertainment/2012/02/david-diamante/diamante-628.jpg",
    "next_page_id": null,
    "rendered_pages": 1
}
 */
public class Parser {

    private String content;
    private String domain;
    private String author;
    private String url;
    private String short_url;
    private String title;
    private String excerpt;
    private String direction;
    private Integer word_count;
    private Integer total_pages;
    private String date_published;
    private String dek;
    private String lead_image_url;
    private String next_page_id;
    private Integer rendered_pages;


    public String getContent()
    {
        return content;
    }

    public void setContent(String content)
    {
        this.content = content;
    }

    public String getDomain()
    {
        return domain;
    }

    public void setDomain(String domain)
    {
        this.domain = domain;
    }

    public String getAuthor()
    {
        return author;
    }

    public void setAuthor(String author)
    {
        this.author = author;
    }

    public String getUrl()
    {
        return url;
    }

    public void setUrl(String url)
    {
        this.url = url;
    }

    public String getShort_url()
    {
        return short_url;
    }

    public void setShort_url(String short_url)
    {
        this.short_url = short_url;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }


}
