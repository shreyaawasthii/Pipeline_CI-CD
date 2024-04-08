const HomePage = browser.page.HomePage();
const LoginFeature = browser.page.LoginFeature();
const ContactUs = browser.page.ContactUs();
const SearchFeature = browser.page.SearchFeature();
const PurchaseProduct = browser.page.PurchaseProduct();


describe('Automation Exercise', () => {
    beforeEach((browser, done) => {
        browser
      .url("https://www.automationexercise.com/")
      //.windowHandleMaximize();

      browser
      .waitForElementVisible(LoginFeature.elements.loginLink)
      .click(LoginFeature.elements.loginLink)
      .waitForElementVisible(LoginFeature.elements.emailInput)
      .setValue(LoginFeature.elements.emailInput, 'demouser@gmail.com')
      .waitForElementVisible(LoginFeature.elements.passwordInput)
      .setValue(LoginFeature.elements.passwordInput, 'password123')
      .click(LoginFeature.elements.loginButton)
      .waitForElementVisible(LoginFeature.elements.logoutLink);

done();
});

    afterEach(() => {
        browser.end();
  });

  // it('Verify that the elements of HomePage are visible', function(browser) {
  //   browser.verifyHomePage();
  // });

  it('Verify that the elements of HomePage are visible', function(browser) {
    browser
      //.waitForElementVisible(HomePage.elements.header, 5000, 'Element @header is visible.')
      //.assert.titleContains('Automation Exercise')
      //.assert.visible(HomePage.elements.homeLink, 'Element @homeLink is visible.')
      //.assert.visible(HomePage.elements.navBar, 'Element @navBar is visible.');
  });


//   it('Verify that the elements of contact us page are working fine', function(browser) {
//     browser
//       .click(ContactUs.elements.contactUsLink)
//       .assert.visible(ContactUs.elements.contactForm)
//       .setValue(ContactUs.elements.nameInput, 'Demo')
//       .setValue(ContactUs.elements.emailInput, 'demouser@gmail.com')
//       .setValue(ContactUs.elements.subjectInput, 'testing features')
//       .setValue(ContactUs.elements.messageInput, 'Checking the functionality of the Contact Us page')
//       .setValue(ContactUs.elements.uploadFileInput, require('path').resolve('/home/knoldus/Pictures/Selection_003.png'))
//       .pause(2000);
//   });

//  it('Verify that the search feature is working', function(browser) {
//   browser
//     .assert.visible(SearchFeature.elements.productsLink, 'Element @productsLink is visible.')
//     .click(SearchFeature.elements.productsLink)
//     .assert.visible(SearchFeature.elements.searchInput, 'Element @searchInput is visible.')
//     .setValue(SearchFeature.elements.searchInput, 'Women Dresses')
//     .click(SearchFeature.elements.searchButton)
//     .assert.containsText(SearchFeature.elements.searchResultsTitle, 'SEARCHED PRODUCTS');
// });

// it('Verify that the user is able to purchase a product successfully', function(browser) {
//   browser
//     .assert.visible(PurchaseProduct.elements.productLink)
//     .click(PurchaseProduct.elements.productLink)
//     .assert.visible(PurchaseProduct.elements.viewProduct)
//     .setValue(PurchaseProduct.elements.quantityInput, '5')
//     .click(PurchaseProduct.elements.addToCartButton)
//     .waitForElementPresent(PurchaseProduct.elements.modalTitle)
//     .assert.visible(PurchaseProduct.elements.modalTitle)
//     .click(PurchaseProduct.elements.viewCartButton)
//     .assert.visible(PurchaseProduct.elements.checkoutButton)
//     .click(PurchaseProduct.elements.checkoutButton);
// });

});
