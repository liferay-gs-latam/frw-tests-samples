const tests = require.context('./', true, /index\.js$/);

tests.keys().forEach(tests);

const sources = require.context('../src/', true, /index\.js$/);

sources.keys().forEach(sources);
