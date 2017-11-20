describe("Test Suite Verify", function() {
  var Helloworld = require('../../src/code/Helloworld');
  var Person = require('../../src/code/Person');

  it('Verify if hello world was displayed', function () {
    var helloworld = new Helloworld();
    expect(helloworld.message()).toEqual('Hello world!');
  });

  it('Verify if sayHello() function was called by other method', function () {
    var fakePerson = new Person();
    spyOn(fakePerson, 'sayHello');
    fakePerson.helloSomeone('world');
    expect(fakePerson.sayHello).toHaveBeenCalled();
  });

  it('Verify if helloSomeone() function was called by presence of parameter', function () {
    var fakePerson = new Person();
    spyOn(fakePerson, 'helloSomeone');
    fakePerson.helloSomeone('world');
    expect(fakePerson.helloSomeone).toHaveBeenCalledWith('world');
  });

  it('Verify if helloSomeone() function was called by not presence of parameter', function () {
    var fakePerson = new Person();
    spyOn(fakePerson, 'helloSomeone');
    fakePerson.helloSomeone('world');
    expect(fakePerson.helloSomeone).not.toHaveBeenCalledWith('foo');
  });
});