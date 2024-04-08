module.exports = {
    'Verify Product Purchase flow': function (browser) {
    browser
    .url('https://www.automationexercise.com/') 
    .maximizeWindow()
    .useXpath()
    .assert.visible('//a[contains(text(), "Products")]')
    .click('//a[contains(text(), "Products")]')
    .useCss()
    .execute('scrollTo(0,document.body.scrollHeight)')
    .getLocationInView('a[href="/product_details/4"]', function(result) {
    
    })
    .click('a[href="/product_details/4"]')
    .assert.visible('.view-product')
    .setValue('#quantity','5')
    .click('.btn.btn-default.cart')
    .waitForElementPresent('.modal-title.w-100')
    .assert.visible('.modal-title.w-100')
    .click('.modal-body a[href="/view_cart"]')
    .assert.visible('.btn.btn-default.check_out')
    .click('.btn.btn-default.check_out')
    .end();
    },
    };