This application tests ejbs, and the multi-buildpack via use of the simple-buildpack (to be renamed) and the tomee-buildpack.

Create a user-provided service as follows:

{
    "credentials": {
     "class-name": "org.cloudfoundry.test.MyType",
     "id": "someId",
     "includeInResources": "true",
     "name1": "val1",
     "name2": "val2"
    },
    "label": "user-provided",
    "name": "my-test-resource",
    "syslog_drain_url": "",
    "tags": [],
    "volume_mounts": []
   }

and bind it to the application.  After a push, `cf ssh` into the application:

`cf ssh ejb-application`

and view the resources.xml file:

`less ./app/WEB-INF/resources.xml`

You should see content like this:

```xml
<resources
><Resource class-name='org.cloudfoundry.test.MyType' id='someId'
    >name1 = val1
name2 = val2
</Resource
    ></resources
>
```

Lastly, if you curl the /my-type/check-my-type endpoint of the application, you should see

```
name1 = val1 and name2 = val2
```
