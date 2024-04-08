module.exports = {
  elements: {
    header: '#header',
    homeLink: {
      selector: '//a[contains(@href, "/") and contains(text(), "Home")]',
      locateStrategy: 'xpath',
    },
    navBar: '.nav.navbar-nav',
  },
  // commands: {
  //   verifyHomePage() {
  //     return this.api
  //       .waitForElementVisible('@header')
  //       .assert.titleContains('Automation Exercise')
  //       .assert.visible('@homeLink, @navBar');
  //   },
  // },
};