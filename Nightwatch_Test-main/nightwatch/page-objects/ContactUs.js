module.exports = {
    elements: {
      contactUsLink: 'a[href*="/contact_us"]',
      contactForm: '.contact-form.row',
      nameInput: 'input[name="name"]',
      emailInput: 'input[name="email"]',
      subjectInput: 'input[name="subject"]',
      messageInput: '#message',
      uploadFileInput: 'input[name="upload_file"]',
    },
    // commands: {
    //   submitContactForm(name, email, subject, message, filePath) {
    //     this.api.assert.visible('@contactUsLink').click('@contactUsLink')
    //       .assert.visible('@contactForm').setValue('@nameInput', name)
    //       .setValue('@emailInput', email).setValue('@subjectInput', subject)
    //       .setValue('@messageInput', message).setValue('@uploadFileInput', require('path').resolve(filePath))
    //       .pause(2000);
    //     return this;
    //   },
    // },
  };