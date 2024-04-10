This is a simple dockerized Spring-Spark web app for the sake of comparison with a Ktor-Spark app.
Both apps dynamically invoke a local Spark job when [http://localhost:8888](http://localhost:8888) is requested.
However, the Ktor-Spark app throws an `org.apache.hadoop.fs.UnsupportedFileSystemException` exception, whereas
the Spring-Spark app does not.

([GitHub issue](https://github.com/Kotlin/kotlin-spark-api/issues/219))

In a shell, run:
```shell
$ docker compose up
```
Then, open [http://localhost:8888](http://localhost:8888) in a browser.
The following array should be displayed:
```shell
[6, 7, 8, 9, 10]
```
Output similar to the following should be displayed in the shell terminal:
```shell
 ✔ Network spring-spark_default  Created                                                                                                                                0.1s 
 ✔ Container spring-spark-app-1  Created                                                                                                                                0.1s 
Attaching to app-1
app-1  | 
app-1  |   .   ____          _            __ _ _
app-1  |  /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
app-1  | ( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
app-1  |  \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
app-1  |   '  |____| .__|_| |_|_| |_\__, | / / / /
app-1  |  =========|_|==============|___/=/_/_/_/
app-1  |  :: Spring Boot ::               (v2.7.10)
app-1  | 
app-1  | 2024-04-10 09:00:22.600  INFO 1 --- [           main] c.e.Application                          : Starting Application using Java 11.0.22 on 1d1b66d9e151 with PID 1 (/app/app.jar started by root in /)
app-1  | 2024-04-10 09:00:22.606  INFO 1 --- [           main] c.e.Application                          : No active profile set, falling back to 1 default profile: "default"
app-1  | 2024-04-10 09:00:23.585  INFO 1 --- [           main] o.s.b.w.e.t.TomcatWebServer              : Tomcat initialized with port(s): 8888 (http)
app-1  | 2024-04-10 09:00:23.594  INFO 1 --- [           main] o.a.c.c.StandardService                  : Starting service [Tomcat]
app-1  | 2024-04-10 09:00:23.594  INFO 1 --- [           main] o.a.c.c.StandardEngine                   : Starting Servlet engine: [Apache Tomcat/9.0.73]
app-1  | 2024-04-10 09:00:23.671  INFO 1 --- [           main] o.a.c.c.C.[.[.[/]                        : Initializing Spring embedded WebApplicationContext
app-1  | 2024-04-10 09:00:23.671  INFO 1 --- [           main] w.s.c.ServletWebServerApplicationContext : Root WebApplicationContext: initialization completed in 1012 ms
app-1  | 2024-04-10 09:00:24.063  INFO 1 --- [           main] o.s.b.w.e.t.TomcatWebServer              : Tomcat started on port(s): 8888 (http) with context path ''
app-1  | 2024-04-10 09:00:24.076  INFO 1 --- [           main] c.e.Application                          : Started Application in 2.009 seconds (JVM running for 3.082)
app-1  | 2024-04-10 09:00:42.305  INFO 1 --- [nio-8888-exec-1] o.a.c.c.C.[.[.[/]                        : Initializing Spring DispatcherServlet 'dispatcherServlet'
app-1  | 2024-04-10 09:00:42.305  INFO 1 --- [nio-8888-exec-1] o.s.w.s.DispatcherServlet                : Initializing Servlet 'dispatcherServlet'
app-1  | 2024-04-10 09:00:42.306  INFO 1 --- [nio-8888-exec-1] o.s.w.s.DispatcherServlet                : Completed initialization in 1 ms
app-1  | 2024-04-10 09:00:42.739  INFO 1 --- [nio-8888-exec-1] o.a.s.SparkContext                       : Running Spark version 3.3.2
app-1  | 2024-04-10 09:00:42.885  WARN 1 --- [nio-8888-exec-1] o.a.h.u.NativeCodeLoader                 : Unable to load native-hadoop library for your platform... using builtin-java classes where applicable
app-1  | 2024-04-10 09:00:42.984  INFO 1 --- [nio-8888-exec-1] o.a.s.r.ResourceUtils                    : ==============================================================
app-1  | 2024-04-10 09:00:42.984  INFO 1 --- [nio-8888-exec-1] o.a.s.r.ResourceUtils                    : No custom resources configured for spark.driver.
app-1  | 2024-04-10 09:00:42.984  INFO 1 --- [nio-8888-exec-1] o.a.s.r.ResourceUtils                    : ==============================================================
app-1  | 2024-04-10 09:00:42.985  INFO 1 --- [nio-8888-exec-1] o.a.s.SparkContext                       : Submitted application: JavaBroadcast
app-1  | 2024-04-10 09:00:43.007  INFO 1 --- [nio-8888-exec-1] o.a.s.r.ResourceProfile                  : Default ResourceProfile created, executor resources: Map(cores -> name: cores, amount: 1, script: , vendor: , memory -> name: memory, amount: 1024, script: , vendor: , offHeap -> name: offHeap, amount: 0, script: , vendor: ), task resources: Map(cpus -> name: cpus, amount: 1.0)
app-1  | 2024-04-10 09:00:43.011  INFO 1 --- [nio-8888-exec-1] o.a.s.r.ResourceProfile                  : Limiting resource is cpu
app-1  | 2024-04-10 09:00:43.012  INFO 1 --- [nio-8888-exec-1] o.a.s.r.ResourceProfileManager           : Added ResourceProfile id: 0
app-1  | 2024-04-10 09:00:43.070  INFO 1 --- [nio-8888-exec-1] o.a.s.SecurityManager                    : Changing view acls to: root
app-1  | 2024-04-10 09:00:43.070  INFO 1 --- [nio-8888-exec-1] o.a.s.SecurityManager                    : Changing modify acls to: root
app-1  | 2024-04-10 09:00:43.070  INFO 1 --- [nio-8888-exec-1] o.a.s.SecurityManager                    : Changing view acls groups to: 
app-1  | 2024-04-10 09:00:43.071  INFO 1 --- [nio-8888-exec-1] o.a.s.SecurityManager                    : Changing modify acls groups to: 
app-1  | 2024-04-10 09:00:43.071  INFO 1 --- [nio-8888-exec-1] o.a.s.SecurityManager                    : SecurityManager: authentication disabled; ui acls disabled; users  with view permissions: Set(root); groups with view permissions: Set(); users  with modify permissions: Set(root); groups with modify permissions: Set()
app-1  | 2024-04-10 09:00:43.320  INFO 1 --- [nio-8888-exec-1] o.a.s.u.Utils                            : Successfully started service 'sparkDriver' on port 40059.
app-1  | 2024-04-10 09:00:43.343  INFO 1 --- [nio-8888-exec-1] o.a.s.SparkEnv                           : Registering MapOutputTracker
app-1  | WARNING: An illegal reflective access operation has occurred
app-1  | WARNING: Illegal reflective access by org.apache.spark.unsafe.Platform (jar:file:/app/app.jar!/BOOT-INF/lib/spark-unsafe_2.13-3.3.2.jar!/) to constructor java.nio.DirectByteBuffer(long,int)
app-1  | WARNING: Please consider reporting this to the maintainers of org.apache.spark.unsafe.Platform
app-1  | WARNING: Use --illegal-access=warn to enable warnings of further illegal reflective access operations
app-1  | WARNING: All illegal access operations will be denied in a future release
app-1  | 2024-04-10 09:00:43.370  INFO 1 --- [nio-8888-exec-1] o.a.s.SparkEnv                           : Registering BlockManagerMaster
app-1  | 2024-04-10 09:00:43.390  INFO 1 --- [nio-8888-exec-1] o.a.s.s.BlockManagerMasterEndpoint       : Using org.apache.spark.storage.DefaultTopologyMapper for getting topology information
app-1  | 2024-04-10 09:00:43.390  INFO 1 --- [nio-8888-exec-1] o.a.s.s.BlockManagerMasterEndpoint       : BlockManagerMasterEndpoint up
app-1  | 2024-04-10 09:00:43.393  INFO 1 --- [nio-8888-exec-1] o.a.s.SparkEnv                           : Registering BlockManagerMasterHeartbeat
app-1  | 2024-04-10 09:00:43.410  INFO 1 --- [nio-8888-exec-1] o.a.s.s.DiskBlockManager                 : Created local directory at /tmp/blockmgr-c9cef486-62f2-431a-8408-1e48b933da34
app-1  | 2024-04-10 09:00:43.436  INFO 1 --- [nio-8888-exec-1] o.a.s.s.m.MemoryStore                    : MemoryStore started with capacity 2.1 GiB
app-1  | 2024-04-10 09:00:43.447  INFO 1 --- [nio-8888-exec-1] o.a.s.SparkEnv                           : Registering OutputCommitCoordinator
app-1  | 2024-04-10 09:00:43.477  INFO 1 --- [nio-8888-exec-1] o.s.j.u.log                              : Logging initialized @22482ms to org.sparkproject.jetty.util.log.Slf4jLog
app-1  | 2024-04-10 09:00:43.552  INFO 1 --- [nio-8888-exec-1] o.s.j.s.Server                           : jetty-9.4.48.v20220622; built: 2022-06-21T20:42:25.880Z; git: 6b67c5719d1f4371b33655ff2d047d24e171e49a; jvm 11.0.22+7
app-1  | 2024-04-10 09:00:43.569  INFO 1 --- [nio-8888-exec-1] o.s.j.s.Server                           : Started @22575ms
app-1  | 2024-04-10 09:00:43.593  INFO 1 --- [nio-8888-exec-1] o.s.j.s.AbstractConnector                : Started ServerConnector@7890a698{HTTP/1.1, (http/1.1)}{0.0.0.0:4040}
app-1  | 2024-04-10 09:00:43.593  INFO 1 --- [nio-8888-exec-1] o.a.s.u.Utils                            : Successfully started service 'SparkUI' on port 4040.
app-1  | 2024-04-10 09:00:43.607  INFO 1 --- [nio-8888-exec-1] o.s.j.s.h.ContextHandler                 : Started o.s.j.s.ServletContextHandler@413a1aa4{/,null,AVAILABLE,@Spark}
app-1  | 2024-04-10 09:00:43.686  INFO 1 --- [nio-8888-exec-1] o.a.s.e.Executor                         : Starting executor ID driver on host 1d1b66d9e151
app-1  | 2024-04-10 09:00:43.692  INFO 1 --- [nio-8888-exec-1] o.a.s.e.Executor                         : Starting executor with user classpath (userClassPathFirst = false): ''
app-1  | 2024-04-10 09:00:43.708  INFO 1 --- [nio-8888-exec-1] o.a.s.u.Utils                            : Successfully started service 'org.apache.spark.network.netty.NettyBlockTransferService' on port 43605.
app-1  | 2024-04-10 09:00:43.708  INFO 1 --- [nio-8888-exec-1] o.a.s.n.n.NettyBlockTransferService      : Server created on 1d1b66d9e151:43605
app-1  | 2024-04-10 09:00:43.710  INFO 1 --- [nio-8888-exec-1] o.a.s.s.BlockManager                     : Using org.apache.spark.storage.RandomBlockReplicationPolicy for block replication policy
app-1  | 2024-04-10 09:00:43.714  INFO 1 --- [nio-8888-exec-1] o.a.s.s.BlockManagerMaster               : Registering BlockManager BlockManagerId(driver, 1d1b66d9e151, 43605, None)
app-1  | 2024-04-10 09:00:43.718  INFO 1 --- [ckManagerMaster] o.a.s.s.BlockManagerMasterEndpoint       : Registering block manager 1d1b66d9e151:43605 with 2.1 GiB RAM, BlockManagerId(driver, 1d1b66d9e151, 43605, None)
app-1  | 2024-04-10 09:00:43.720  INFO 1 --- [nio-8888-exec-1] o.a.s.s.BlockManagerMaster               : Registered BlockManager BlockManagerId(driver, 1d1b66d9e151, 43605, None)
app-1  | 2024-04-10 09:00:43.721  INFO 1 --- [nio-8888-exec-1] o.a.s.s.BlockManager                     : Initialized BlockManager: BlockManagerId(driver, 1d1b66d9e151, 43605, None)
app-1  | 2024-04-10 09:00:43.746  INFO 1 --- [nio-8888-exec-1] o.s.j.s.h.ContextHandler                 : Stopped o.s.j.s.ServletContextHandler@413a1aa4{/,null,STOPPED,@Spark}
app-1  | 2024-04-10 09:00:43.747  INFO 1 --- [nio-8888-exec-1] o.s.j.s.h.ContextHandler                 : Started o.s.j.s.ServletContextHandler@44753364{/jobs,null,AVAILABLE,@Spark}
app-1  | 2024-04-10 09:00:43.748  INFO 1 --- [nio-8888-exec-1] o.s.j.s.h.ContextHandler                 : Started o.s.j.s.ServletContextHandler@380e638b{/jobs/json,null,AVAILABLE,@Spark}
app-1  | 2024-04-10 09:00:43.749  INFO 1 --- [nio-8888-exec-1] o.s.j.s.h.ContextHandler                 : Started o.s.j.s.ServletContextHandler@1f339648{/jobs/job,null,AVAILABLE,@Spark}
app-1  | 2024-04-10 09:00:43.751  INFO 1 --- [nio-8888-exec-1] o.s.j.s.h.ContextHandler                 : Started o.s.j.s.ServletContextHandler@6dec5e56{/jobs/job/json,null,AVAILABLE,@Spark}
app-1  | 2024-04-10 09:00:43.752  INFO 1 --- [nio-8888-exec-1] o.s.j.s.h.ContextHandler                 : Started o.s.j.s.ServletContextHandler@6f2ed598{/stages,null,AVAILABLE,@Spark}
app-1  | 2024-04-10 09:00:43.752  INFO 1 --- [nio-8888-exec-1] o.s.j.s.h.ContextHandler                 : Started o.s.j.s.ServletContextHandler@3bcc0d50{/stages/json,null,AVAILABLE,@Spark}
app-1  | 2024-04-10 09:00:43.753  INFO 1 --- [nio-8888-exec-1] o.s.j.s.h.ContextHandler                 : Started o.s.j.s.ServletContextHandler@6ffee65f{/stages/stage,null,AVAILABLE,@Spark}
app-1  | 2024-04-10 09:00:43.754  INFO 1 --- [nio-8888-exec-1] o.s.j.s.h.ContextHandler                 : Started o.s.j.s.ServletContextHandler@5d1eb5bf{/stages/stage/json,null,AVAILABLE,@Spark}
app-1  | 2024-04-10 09:00:43.755  INFO 1 --- [nio-8888-exec-1] o.s.j.s.h.ContextHandler                 : Started o.s.j.s.ServletContextHandler@648d8963{/stages/pool,null,AVAILABLE,@Spark}
app-1  | 2024-04-10 09:00:43.755  INFO 1 --- [nio-8888-exec-1] o.s.j.s.h.ContextHandler                 : Started o.s.j.s.ServletContextHandler@49affc2{/stages/pool/json,null,AVAILABLE,@Spark}
app-1  | 2024-04-10 09:00:43.756  INFO 1 --- [nio-8888-exec-1] o.s.j.s.h.ContextHandler                 : Started o.s.j.s.ServletContextHandler@3a1e5e4c{/storage,null,AVAILABLE,@Spark}
app-1  | 2024-04-10 09:00:43.757  INFO 1 --- [nio-8888-exec-1] o.s.j.s.h.ContextHandler                 : Started o.s.j.s.ServletContextHandler@4d29f1c5{/storage/json,null,AVAILABLE,@Spark}
app-1  | 2024-04-10 09:00:43.758  INFO 1 --- [nio-8888-exec-1] o.s.j.s.h.ContextHandler                 : Started o.s.j.s.ServletContextHandler@3710b53f{/storage/rdd,null,AVAILABLE,@Spark}
app-1  | 2024-04-10 09:00:43.759  INFO 1 --- [nio-8888-exec-1] o.s.j.s.h.ContextHandler                 : Started o.s.j.s.ServletContextHandler@580fa09e{/storage/rdd/json,null,AVAILABLE,@Spark}
app-1  | 2024-04-10 09:00:43.759  INFO 1 --- [nio-8888-exec-1] o.s.j.s.h.ContextHandler                 : Started o.s.j.s.ServletContextHandler@36290ee2{/environment,null,AVAILABLE,@Spark}
app-1  | 2024-04-10 09:00:43.760  INFO 1 --- [nio-8888-exec-1] o.s.j.s.h.ContextHandler                 : Started o.s.j.s.ServletContextHandler@1f8fbd87{/environment/json,null,AVAILABLE,@Spark}
app-1  | 2024-04-10 09:00:43.761  INFO 1 --- [nio-8888-exec-1] o.s.j.s.h.ContextHandler                 : Started o.s.j.s.ServletContextHandler@724ed7d9{/executors,null,AVAILABLE,@Spark}
app-1  | 2024-04-10 09:00:43.762  INFO 1 --- [nio-8888-exec-1] o.s.j.s.h.ContextHandler                 : Started o.s.j.s.ServletContextHandler@25d3977c{/executors/json,null,AVAILABLE,@Spark}
app-1  | 2024-04-10 09:00:43.763  INFO 1 --- [nio-8888-exec-1] o.s.j.s.h.ContextHandler                 : Started o.s.j.s.ServletContextHandler@5904fa40{/executors/threadDump,null,AVAILABLE,@Spark}
app-1  | 2024-04-10 09:00:43.763  INFO 1 --- [nio-8888-exec-1] o.s.j.s.h.ContextHandler                 : Started o.s.j.s.ServletContextHandler@341fb80f{/executors/threadDump/json,null,AVAILABLE,@Spark}
app-1  | 2024-04-10 09:00:43.772  INFO 1 --- [nio-8888-exec-1] o.s.j.s.h.ContextHandler                 : Started o.s.j.s.ServletContextHandler@17ebd0f8{/static,null,AVAILABLE,@Spark}
app-1  | 2024-04-10 09:00:43.772  INFO 1 --- [nio-8888-exec-1] o.s.j.s.h.ContextHandler                 : Started o.s.j.s.ServletContextHandler@3948f6d2{/,null,AVAILABLE,@Spark}
app-1  | 2024-04-10 09:00:43.774  INFO 1 --- [nio-8888-exec-1] o.s.j.s.h.ContextHandler                 : Started o.s.j.s.ServletContextHandler@ab120d{/api,null,AVAILABLE,@Spark}
app-1  | 2024-04-10 09:00:43.775  INFO 1 --- [nio-8888-exec-1] o.s.j.s.h.ContextHandler                 : Started o.s.j.s.ServletContextHandler@7df97672{/jobs/job/kill,null,AVAILABLE,@Spark}
app-1  | 2024-04-10 09:00:43.775  INFO 1 --- [nio-8888-exec-1] o.s.j.s.h.ContextHandler                 : Started o.s.j.s.ServletContextHandler@3f0cbdbe{/stages/stage/kill,null,AVAILABLE,@Spark}
app-1  | 2024-04-10 09:00:43.779  INFO 1 --- [nio-8888-exec-1] o.s.j.s.h.ContextHandler                 : Started o.s.j.s.ServletContextHandler@7bf198fa{/metrics/json,null,AVAILABLE,@Spark}
app-1  | 2024-04-10 09:00:43.829  INFO 1 --- [nio-8888-exec-1] o.a.s.s.m.MemoryStore                    : Block broadcast_0 stored as values in memory (estimated size 72.0 B, free 2.1 GiB)
app-1  | 2024-04-10 09:00:43.856  INFO 1 --- [nio-8888-exec-1] o.a.s.s.m.MemoryStore                    : Block broadcast_0_piece0 stored as bytes in memory (estimated size 146.0 B, free 2.1 GiB)
app-1  | 2024-04-10 09:00:43.858  INFO 1 --- [ckManagerMaster] o.a.s.s.BlockManagerInfo                 : Added broadcast_0_piece0 in memory on 1d1b66d9e151:43605 (size: 146.0 B, free: 2.1 GiB)
app-1  | 2024-04-10 09:00:43.862  INFO 1 --- [nio-8888-exec-1] o.a.s.SparkContext                       : Created broadcast 0 from broadcast at SparkBroadcast.java:30
app-1  | 2024-04-10 09:00:44.128  INFO 1 --- [nio-8888-exec-1] o.a.s.SparkContext                       : Starting job: collect at SparkBroadcast.java:32
app-1  | 2024-04-10 09:00:44.141  INFO 1 --- [uler-event-loop] o.a.s.s.DAGScheduler                     : Got job 0 (collect at SparkBroadcast.java:32) with 1 output partitions
app-1  | 2024-04-10 09:00:44.141  INFO 1 --- [uler-event-loop] o.a.s.s.DAGScheduler                     : Final stage: ResultStage 0 (collect at SparkBroadcast.java:32)
app-1  | 2024-04-10 09:00:44.142  INFO 1 --- [uler-event-loop] o.a.s.s.DAGScheduler                     : Parents of final stage: List()
app-1  | 2024-04-10 09:00:44.144  INFO 1 --- [uler-event-loop] o.a.s.s.DAGScheduler                     : Missing parents: List()
app-1  | 2024-04-10 09:00:44.147  INFO 1 --- [uler-event-loop] o.a.s.s.DAGScheduler                     : Submitting ResultStage 0 (MapPartitionsRDD[1] at map at SparkBroadcast.java:32), which has no missing parents
app-1  | 2024-04-10 09:00:44.162  INFO 1 --- [uler-event-loop] o.a.s.s.m.MemoryStore                    : Block broadcast_1 stored as values in memory (estimated size 4.8 KiB, free 2.1 GiB)
app-1  | 2024-04-10 09:00:44.168  INFO 1 --- [uler-event-loop] o.a.s.s.m.MemoryStore                    : Block broadcast_1_piece0 stored as bytes in memory (estimated size 2.6 KiB, free 2.1 GiB)
app-1  | 2024-04-10 09:00:44.168  INFO 1 --- [ckManagerMaster] o.a.s.s.BlockManagerInfo                 : Added broadcast_1_piece0 in memory on 1d1b66d9e151:43605 (size: 2.6 KiB, free: 2.1 GiB)
app-1  | 2024-04-10 09:00:44.169  INFO 1 --- [uler-event-loop] o.a.s.SparkContext                       : Created broadcast 1 from broadcast at DAGScheduler.scala:1513
app-1  | 2024-04-10 09:00:44.183  INFO 1 --- [uler-event-loop] o.a.s.s.DAGScheduler                     : Submitting 1 missing tasks from ResultStage 0 (MapPartitionsRDD[1] at map at SparkBroadcast.java:32) (first 15 tasks are for partitions Vector(0))
app-1  | 2024-04-10 09:00:44.184  INFO 1 --- [uler-event-loop] o.a.s.s.TaskSchedulerImpl                : Adding task set 0.0 with 1 tasks resource profile 0
app-1  | 2024-04-10 09:00:44.237  INFO 1 --- [er-event-loop-0] o.a.s.s.TaskSetManager                   : Starting task 0.0 in stage 0.0 (TID 0) (1d1b66d9e151, executor driver, partition 0, PROCESS_LOCAL, 7509 bytes) taskResourceAssignments Map()
app-1  | 2024-04-10 09:00:44.250  INFO 1 --- [age 0.0 (TID 0)] o.a.s.e.Executor                         : Running task 0.0 in stage 0.0 (TID 0)
app-1  | 2024-04-10 09:00:44.308  INFO 1 --- [age 0.0 (TID 0)] o.a.s.e.Executor                         : Finished task 0.0 in stage 0.0 (TID 0). 1051 bytes result sent to driver
app-1  | 2024-04-10 09:00:44.314  INFO 1 --- [result-getter-0] o.a.s.s.TaskSetManager                   : Finished task 0.0 in stage 0.0 (TID 0) in 89 ms on 1d1b66d9e151 (executor driver) (1/1)
app-1  | 2024-04-10 09:00:44.315  INFO 1 --- [result-getter-0] o.a.s.s.TaskSchedulerImpl                : Removed TaskSet 0.0, whose tasks have all completed, from pool 
app-1  | 2024-04-10 09:00:44.320  INFO 1 --- [uler-event-loop] o.a.s.s.DAGScheduler                     : ResultStage 0 (collect at SparkBroadcast.java:32) finished in 0.162 s
app-1  | 2024-04-10 09:00:44.322  INFO 1 --- [uler-event-loop] o.a.s.s.DAGScheduler                     : Job 0 is finished. Cancelling potential speculative or zombie tasks for this job
app-1  | 2024-04-10 09:00:44.322  INFO 1 --- [uler-event-loop] o.a.s.s.TaskSchedulerImpl                : Killing all running tasks in stage 0: Stage finished
app-1  | 2024-04-10 09:00:44.323  INFO 1 --- [nio-8888-exec-1] o.a.s.s.DAGScheduler                     : Job 0 finished: collect at SparkBroadcast.java:32, took 0.194900 s
app-1  | [6, 7, 8, 9, 10]
app-1  | 2024-04-10 09:00:44.329  INFO 1 --- [nio-8888-exec-1] o.s.j.s.AbstractConnector                : Stopped Spark@7890a698{HTTP/1.1, (http/1.1)}{0.0.0.0:4040}
app-1  | 2024-04-10 09:00:44.333  INFO 1 --- [nio-8888-exec-1] o.a.s.u.SparkUI                          : Stopped Spark web UI at http://1d1b66d9e151:4040
app-1  | 2024-04-10 09:00:44.341  INFO 1 --- [er-event-loop-1] o.a.s.MapOutputTrackerMasterEndpoint     : MapOutputTrackerMasterEndpoint stopped!
app-1  | 2024-04-10 09:00:44.349  INFO 1 --- [nio-8888-exec-1] o.a.s.s.m.MemoryStore                    : MemoryStore cleared
app-1  | 2024-04-10 09:00:44.349  INFO 1 --- [nio-8888-exec-1] o.a.s.s.BlockManager                     : BlockManager stopped
app-1  | 2024-04-10 09:00:44.354  INFO 1 --- [nio-8888-exec-1] o.a.s.s.BlockManagerMaster               : BlockManagerMaster stopped
app-1  | 2024-04-10 09:00:44.356  INFO 1 --- [er-event-loop-1] rdinator$OutputCommitCoordinatorEndpoint : OutputCommitCoordinator stopped!
app-1  | 2024-04-10 09:00:44.358  INFO 1 --- [nio-8888-exec-1] o.a.s.SparkContext                       : Successfully stopped SparkContext
```