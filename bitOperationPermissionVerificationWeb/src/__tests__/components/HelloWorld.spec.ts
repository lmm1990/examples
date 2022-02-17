import { describe, it, expect } from "vitest";

import { mount } from "@vue/test-utils";
import HelloWorld from "@/components/HelloWorld/HelloWorld.vue";

describe("HelloWorld", () => {
  it("renders properly", () => {
    const wrapper = mount(HelloWorld, { props: { msg: "Hello Vitest" } });
    expect(wrapper.text()).toContain("当前权限：");
  });
});
