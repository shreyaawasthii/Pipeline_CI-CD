module.exports =  {
    // elements : {
       
    //     productLink: '#item_4_title_link > div', 
    //     addToCartButton: '#add-to-cart-sauce-labs-backpack',
    // },
    commands : [
        {
            openBrowser: function () {
                browser.windowMaximize().url(this.url);  
                browser.waitForElementVisible('body', 2000, 'website loaded successfully');
                return this;
            },
        
            closeBrowser: function () {
                browser.end();
                return this;
            },
            addToCart: function () {
                browser
                    .waitForElementPresent('#item_4_title_link > div ', 5000, 'Product link present')
                    .click('#item_4_title_link > div')
                    .waitForElementPresent('#add-to-cart-sauce-labs-backpack', 5000, 'Add to Cart button present')
                    .click('#add-to-cart-sauce-labs-backpack');
                return this;
            },
        },
    ],
};



    
    
