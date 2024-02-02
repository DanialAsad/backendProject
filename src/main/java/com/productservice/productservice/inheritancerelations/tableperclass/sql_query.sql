select u1_0.id, u1_0.clazz_, u1_0.email, u1_0.name, u1_0.average_rating, u1_0.psp, u1_0.session
from (select id, email, name, null as average_rating, null as psp, null as session, 0 as clazz_
      from tpc_user
      union all
      select id, email, name, average_rating, null as psp, null as session, 1 as clazz_
      from tpc_mentors
      union all
      select id, email, name, null as average_rating, psp, null as session, 2 as clazz_
      from tpc_student
      union all
      select id, email, name, null as average_rating, null as psp, session, 3 as clazz_
      from tpc_ta) u1_0