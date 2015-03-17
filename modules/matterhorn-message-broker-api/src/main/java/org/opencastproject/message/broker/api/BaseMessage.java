/**
 *  Copyright 2009, 2010 The Regents of the University of California
 *  Licensed under the Educational Community License, Version 2.0
 *  (the "License"); you may not use this file except in compliance
 *  with the License. You may obtain a copy of the License at
 *
 *  http://www.osedu.org/licenses/ECL-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an "AS IS"
 *  BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 *  or implied. See the License for the specific language governing
 *  permissions and limitations under the License.
 *
 */
package org.opencastproject.message.broker.api;

import org.opencastproject.security.api.JaxbOrganization;
import org.opencastproject.security.api.JaxbUser;
import org.opencastproject.security.api.Organization;
import org.opencastproject.security.api.OrganizationParser;
import org.opencastproject.security.api.User;
import org.opencastproject.security.api.UserParser;

import java.io.Serializable;

public class BaseMessage implements Serializable {

  private static final long serialVersionUID = 3895355230339323251L;

  private final String organization;
  private final String user;
  private final Serializable object;

  public BaseMessage(Organization organization, User user, Serializable object) {
    this.organization = OrganizationParser.toXml(JaxbOrganization.fromOrganization(organization));
    this.user = UserParser.toXml(JaxbUser.fromUser(user));
    this.object = object;
  }

  public Organization getOrganization() {
    return OrganizationParser.fromXml(organization);
  }

  public User getUser() {
    return UserParser.fromXml(user);
  }

  public Serializable getObject() {
    return object;
  }

}