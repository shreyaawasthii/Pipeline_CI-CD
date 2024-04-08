module.exports = {
    verifyHomePage: function () {
      return this.waitForElementVisible('@header')
        .assert.titleContains('Automation Exercise')
        .assert.visible('@homeLink')
        .assert.visible('@navBar');
    },
  };
  